# 拉取jdk8作为基础镜像
FROM openjdk:8-jdk-alpine
# 作者
MAINTAINER zjh <15219742898@163.com>
# 添加jar到镜像并命名为user.jar
ADD ruoyi-admin/target/ruoyi-admin.jar user.jar
# 镜像启动后暴露的端口
EXPOSE 8080
# jar运行命令，参数使用逗号隔开
ENTRYPOINT ["java","-jar","user.jar"]
