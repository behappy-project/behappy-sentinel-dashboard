/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.util.JSONUtils;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
@Component
public final class NacosConfigUtil {
    private final Logger logger = LoggerFactory.getLogger(NacosConfigUtil.class);

    @Autowired
    private NacosParams nacosParams;

    private NacosConfigUtil() {
    }

    /**
     * 将规则序列化成JSON文本，存储到Nacos server中
     *
     * @param configService nacos config service
     * @param app           应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param rules         规则对象
     * @throws NacosException 异常
     */
    public <T> void setRuleStringToNacos(ConfigService configService, String app, String postfix, List<T> rules) throws NacosException {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        String dataId = genDataId(app, postfix);

        // 添加监听器, 用于检测发布配置后未及时同步, 导致分页查询数据还是旧数据
        final boolean[] started = {true};
        Listener listener = new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                started[0] = false;
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        };
        configService.addListener(dataId, nacosParams.getGroupId(), listener);

        try {
            // 持久化
            configService.publishConfig(
                    dataId,
                    nacosParams.getGroupId(),
                    JSONUtils.toJSONString(rules)
            );

            Integer checkCount = nacosParams.getCheckCount();

            int i = 0;
            while (started[0]) {
                if (i >= checkCount) {
                    started[0] = false;
                    break;
                }
                i++;
                Thread.sleep(500);
            }
        } catch (Exception throwable) {
            logger.error("Error set rule nacos", throwable);
        } finally {
            // 检测移除监听器
            configService.removeListener(dataId, nacosParams.getGroupId(), listener);
        }
    }

    /**
     * 从Nacos server中查询响应规则，并将其反序列化成对应Rule实体
     *
     * @param configService nacos config service
     * @param appName       应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param clazz         类
     * @param <T>           泛型
     * @return 规则对象列表
     * @throws NacosException 异常
     */
    public <T> List<T> getRuleEntitiesFromNacos(ConfigService configService, String appName, String postfix, Class<T> clazz) throws NacosException {
        String rules = configService.getConfig(
                genDataId(appName, postfix),
                nacosParams.getGroupId(),
                3000
        );
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return JSONUtils.parseObject(clazz, rules);
    }

    private static String genDataId(String appName, String postfix) {
        return appName + postfix;
    }
}
