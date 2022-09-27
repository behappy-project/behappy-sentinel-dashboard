# Sentinel 控制台(二次开发持久化配置)

## 0. 概述

Sentinel 控制台是流量控制、熔断降级规则统一配置和管理的入口，它为用户提供了机器自发现、簇点链路自发现、监控、规则配置等功能。在 Sentinel 控制台上，我们可以配置规则并实时查看流量控制效果。

### 0.1 测试代码,仓库地址
[test-sentinel](https://github.com/behappy-other/test-sentinel)

## 1. 二次开发

> 分支名规则: v版本号-xx
> 源码分支以`original`结尾
> 以nacos分支结尾则是nacos持久化源码修改版本

## 2. 本地启动

> 先构建前端项目,在weapp/resources下执行npm i && npm run build
> 后端项目构建执行mvn clean package

## 3. docker 构建/启动

> 构建: 在源码修改分支下执行`docker build -t behappy-sentinel-dashboard:v1.8.5-nacos .`
> 启动: 执行`docker run --name behappy-sentinel-dashboard -d -p 8858:8858 behappy-sentinel-dashboard:v1.8.5-nacos`, 
> 替换application文件中的配置参数: `docker run --name behappy-sentinel-dashboard -d -p 8858:8858 behappy-sentinel-dashboard:v1.8.5-nacos -Dxxx=xxx`

## 4. 使用现有的docker镜像进行启动

- docker run --name behappy-sentinel-dashboard -d -p 8858:8858 wangxiaowu950330/behappy-sentinel-dashboard:v1.8.5-nacos

- docker-compose up -d