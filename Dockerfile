# -------------------------- 构建阶段 --------------------------
# 使用国内镜像源加速构建（可选）
FROM maven:3.6.0-jdk-8 as build

# 设置构建阶段工作目录
WORKDIR /app

# 先单独复制 pom.xml 和 settings.xml 利用缓存（避免代码变动时重复下载依赖）
COPY settings.xml pom.xml ./

# 预下载依赖（利用 Docker 层缓存加速构建）
RUN mvn -s /app/settings.xml dependency:go-offline

# 复制源代码（此步骤变动频繁，放在后面减少缓存失效）
COPY src ./src

# 执行构建（跳过测试）
RUN mvn -s /app/settings.xml clean package -DskipTests

# -------------------------- 运行时阶段 --------------------------
# 改用更稳定的 Eclipse Temurin 镜像（自带完整字体库）
FROM eclipse-temurin:8-jre

# 设置容器时区为上海（取消注释并修正）
RUN apt-get update && \
    apt-get install -y tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    rm -rf /var/lib/apt/lists/*

# 安装字体依赖（Alpine 镜像此处需特殊处理，改用 Debian 系镜像更简单）
RUN apt-get update && \
    apt-get install -y fontconfig libfreetype6 && \
    rm -rf /var/lib/apt/lists/*

# 设置工作目录
WORKDIR /app

# 从构建阶段复制 JAR 文件（明确指定文件名避免通配符问题）
COPY --from=build /app/target/springboot-wxcloudrun-1.0.jar .

# 暴露端口
EXPOSE 80

# 启动命令（建议增加 JVM 参数优化）
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/springboot-wxcloudrun-1.0.jar"]