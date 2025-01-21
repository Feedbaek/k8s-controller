FROM openjdk:17

COPY ./target/k8s_controller-0.0.1-SNAPSHOT.jar /k8s_controller.jar

ENTRYPOINT ["java", "-jar", "/k8s_controller.jar"]