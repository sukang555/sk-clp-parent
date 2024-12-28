FROM alpine:latest

RUN apk update  \
    && apk add openjdk8 curl busybox tzdata   \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime  \
    && echo Asia/Shanghai > /etc/timezone  \
    && rm -rf /tmp/* /var/cache/apk/* && \
    mkdir /app

ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV CLASSPATH=/usr/lib/jvm/default-jvm/lib/dt.jar:/usr/lib/jvm/default-jvm/lib/tools.jar:/usr/lib/jvm/default-jvm/jre/lib/rt.jar
ENV PATH=/usr/lib/jvm/default-jvm/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin LC_ALL=zh_CN.UTF-8 LANG=zh_CN.UTF-8 LANGUAGE=zh_CN.UTF-8 TERM=xterm-256color



WORKDIR /app



