#!/usr/bin/env bash
workdir=/opt/sentinel
# 更新国内源
mv Centos-7.repo /etc/yum.repos.d/CentOS-Base \
&& yum clean all \
&& yum makecache \
&& yum update -y \
&& mkdir -p $workdir
cd $workdir
# 下载jdk8
yum install -y wget java-1.8.0-openjdk*
# 下载node v10.14.2
wget https://npm.taobao.org/mirrors/node/v10.14.2/node-v10.14.2-linux-x64.tar.xz
tar -xvf node-v10.14.2-linux-x64.tar.xz
ln -sf ${workdir}/node-v10.14.2-linux-x64/bin/node /usr/local/bin/node
ln -sf ${workdir}/node-v10.14.2-linux-x64/bin/npm /usr/local/bin/npm
# 下载maven3.8.6
wget --no-check-certificate https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz
tar -xzvf apache-maven-3.8.6-bin.tar.gz
cat >> /etc/profile << EOF
MAVEN_HOME=${workdir}/apache-maven-3.8.6
PATH=$PATH:\$MAVEN_HOME/bin
export PATH
EOF