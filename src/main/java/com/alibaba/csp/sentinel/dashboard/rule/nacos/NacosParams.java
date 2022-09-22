package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Chaim
 * @date 2021/11/13 18:02
 */
@Component
@ConfigurationProperties(prefix = "spring.cloud.sentinel.datasource.nacos")
public class NacosParams {
    private String serverAddr;
    private String groupId;
    private String namespace;

    private String flowDataPostfix;
    private String degradeDataPostfix;
    private String systemDataPostfix;
    private String paramFlowDataPostfix;
    private String authorityDataPostfix;

    private Integer checkCount;


    public static final String FLOW_DATA_ID_POSTFIX = "-flow-rules";
    public static final String DEGRADE_DATA_ID_POSTFIX = "-degrade-rules";
    public static final String SYSTEM_DATA_ID_POSTFIX = "-system-rules";
    public static final String PARAM_FLOW_DATA_ID_POSTFIX = "-param-flow-rules";
    public static final String AUTHORITY_DATA_ID_POSTFIX = "-authority-rules";
    public static final Integer CHECK_COUNT = 6;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getFlowDataPostfix() {
        if (flowDataPostfix == null) {
            return FLOW_DATA_ID_POSTFIX;
        }
        return flowDataPostfix;
    }

    public void setFlowDataPostfix(String flowDataPostfix) {
        this.flowDataPostfix = flowDataPostfix;
    }

    public String getDegradeDataPostfix() {
        if (degradeDataPostfix == null) {
            return DEGRADE_DATA_ID_POSTFIX;
        }
        return degradeDataPostfix;
    }

    public void setDegradeDataPostfix(String degradeDataPostfix) {
        this.degradeDataPostfix = degradeDataPostfix;
    }

    public String getSystemDataPostfix() {
        if (systemDataPostfix == null) {
            return SYSTEM_DATA_ID_POSTFIX;
        }
        return systemDataPostfix;
    }

    public void setSystemDataPostfix(String systemDataPostfix) {
        this.systemDataPostfix = systemDataPostfix;
    }

    public String getParamFlowDataPostfix() {
        if (paramFlowDataPostfix == null) {
            return PARAM_FLOW_DATA_ID_POSTFIX;
        }
        return paramFlowDataPostfix;
    }

    public void setParamFlowDataPostfix(String paramFlowDataPostfix) {
        this.paramFlowDataPostfix = paramFlowDataPostfix;
    }

    public String getAuthorityDataPostfix() {
        if (authorityDataPostfix == null) {
            return AUTHORITY_DATA_ID_POSTFIX;
        }
        return authorityDataPostfix;
    }

    public void setAuthorityDataPostfix(String authorityDataPostfix) {
        this.authorityDataPostfix = authorityDataPostfix;
    }

    public Integer getCheckCount() {
        if (checkCount == null) {
            return CHECK_COUNT;
        }
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }
}
