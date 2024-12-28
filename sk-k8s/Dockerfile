FROM registry.cn-qingdao.aliyuncs.com/sd-app/sd-jdk:lastest

ADD target/k8s-0.0.1-SNAPSHOT.tar.gz /app/

ENV APPLICATION_MAIN com.example.k8s.K8sApplication

RUN apk add --no-cache tini

ENTRYPOINT ["sh","/app/bin/startup.sh"]




