# palindrome_app
Palindrome Application

**Overview**
  -> Create Sample Palindrome Application for Qlik assignment.

**Prerequisites**
  -> Java 1.8
  -> Maven 3
  -> Spring Boot

**o How to build, deploy, test and access your app (i.e., tell us how to run your code)**
  -> Clone the project
  -> Navigate to root path (palindrome_app)
  -> mvn clean install -DskipTests
  -> mvn spring-boot:run

**Run Project**
  -> Invoke following command java -jar palindrome_app-0.0.1-SNAPSHOT.jar navigate to http://localhost:8091/swagger-ui.html
  
**o Brief description of the classes**
  -> PalindromeService class is responsible for checking paragraph is palindrome or not
  
**o Focus on the API and the service; a UI for the API is not expected**
  -> API will accept valid string only and can't take the black string.
  
**o Do not use code generators or third-party libraries**
  -> Not using third-party libraries.
