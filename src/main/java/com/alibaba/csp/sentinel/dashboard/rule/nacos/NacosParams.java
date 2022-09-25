package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Chaim
 * @date 2021/11/13 18:02
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.sentinel.datasource.nacos")
public class NacosParams {
    private String serverAddr;
    private String username;
    private String password;
    private String groupId;
    private String namespace;

    private String flowDataPostfix;
    private String degradeDataPostfix;
    private String systemDataPostfix;
    private String paramFlowDataPostfix;
    private String authorityDataPostfix;

    private String gatewayDataIdPostfix;

    private String gatewayApiDataIdPostfix;

    private Integer checkCount;


    public static final String SERVER_ADDR = "127.0.0.1:8848";
    public static final String GROUP_ID = "DEFAULT_GROUP";
    public static final String NAMESPACE = "";
    public static final String USERNAME = "nacos";
    public static final String PASSWORD = "nacos";
    public static final String FLOW_DATA_ID_POSTFIX = "-flow-rules";
    public static final String DEGRADE_DATA_ID_POSTFIX = "-degrade-rules";
    public static final String SYSTEM_DATA_ID_POSTFIX = "-system-rules";
    public static final String PARAM_FLOW_DATA_ID_POSTFIX = "-param-flow-rules";
    public static final String AUTHORITY_DATA_ID_POSTFIX = "-authority-rules";
    public static final String GATEWAY_DATA_ID_POSTFIX = "-gw-rules";
    public static final String GATEWAY_API_DATA_ID_POSTFIX = "-gw-api-rules";
    public static final Integer CHECK_COUNT = 6;

    public String getServerAddr() {
        if (serverAddr == null) {
            return SERVER_ADDR;
        }
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getGroupId() {
        if (groupId == null) {
            return GROUP_ID;
        }
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getNamespace() {
        if (namespace == null) {
            return NAMESPACE;
        }
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

    public String getGatewayDataIdPostfix() {
        if (gatewayDataIdPostfix == null) {
            return GATEWAY_DATA_ID_POSTFIX;
        }
        return gatewayDataIdPostfix;
    }

    public void setGatewayDataIdPostfix(String gatewayDataIdPostfix) {
        this.gatewayDataIdPostfix = gatewayDataIdPostfix;
    }

    public String getGatewayApiDataIdPostfix() {
        if (gatewayDataIdPostfix == null) {
            return GATEWAY_API_DATA_ID_POSTFIX;
        }
        return gatewayApiDataIdPostfix;
    }

    public void setGatewayApiDataIdPostfix(String gatewayApiDataIdPostfix) {
        this.gatewayApiDataIdPostfix = gatewayApiDataIdPostfix;
    }

    public String getUsername() {
        if (username == null) {
            return USERNAME;
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        if (password == null) {
            return PASSWORD;
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
