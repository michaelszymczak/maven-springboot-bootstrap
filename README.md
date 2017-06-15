#  Maven Spring Boot Bootstrap project

To run

    mvn clean spring-boot:run

To create an executable jar

    mvn clean package && java -jar target/maven-spring-boot-bootstrap-0.1.0.jar

To override the default configuration copy and modify `src/main/resources/application.properties` file
to the same directory as the jar and run it, e.g. `java -jar maven-spring-boot-bootstrap-0.1.0.jar`
The external configuration from the just copied file will be used.
