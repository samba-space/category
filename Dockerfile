FROM amazoncorretto:17-alpine
ARG JAR_FILE=build/libs/category-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} category.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/product.jar"]