FROM amazoncorretto:17-alpine
ARG JAR_FILE=build/libs/category-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} category.jar
ENV AWS_XRAY_DAEMON_ADDRESS=xray-daemon:2000
EXPOSE 8081
ENTRYPOINT ["java","-jar","/category.jar"]