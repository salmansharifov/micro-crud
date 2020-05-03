FROM openjdk:14-alpine
COPY build/libs/demo-user-*-all.jar demo-user.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "demo-user.jar"]