FROM openjdk:22-jdk
RUN mkdir /app
ARG JAR_FILE
ADD target/${JAR_FILE} /app/scheduling-rooms.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "scheduling-rooms.jar"]