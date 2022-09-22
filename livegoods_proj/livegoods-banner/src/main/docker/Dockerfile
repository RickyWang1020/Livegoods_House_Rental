# 基础镜像
FROM openjdk:latest
# 作者信息
LABEL maintainer="abc.com"
# 容器开放端口
EXPOSE 8070
# 将 maven 目录的 jar 包拷贝到 docker 中，并命名为 for_docker.jar
ADD maven/livegoods-banner-1.0-SNAPSHOT.jar livegoods-banner.jar
# 容器启动执行命令
ENTRYPOINT ["java", "-jar", "livegoods-banner.jar"]