# 构建阶段
FROM centos:7 as build
WORKDIR /user/src/app
COPY buildProject.sh Centos-7.repo ./
RUN sh buildProject.sh
COPY . .
# 1.执行构建前端,2.执行构建maven
RUN source /etc/profile \
    && cd /user/src/app/src/main/webapp/resources \
    && npm i --registry=http://registry.npm.taobao.org/ \
    && npm run build \
    && cd /user/src/app \
    && mvn clean package -DskipTests
# 运行阶段
FROM openjdk:8 as runtime
WORKDIR /user/src/app
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
ARG JAR_FILE=/user/src/app/target/*.jar
ENV JAVA_OPTS="-Xms256m -Xmx256m -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["sh","-c","java -jar app.jar ${JAVA_OPTS}"]