# cs-assignment-event-log
-------------------------------------------------------------------------

## Summary - 

This is SpringBoot application with HSQL in-memory database

1. This application takes text log file as input and process the log events.
2. application will flag `alert` (true/false) for the events which takes more the 4ms.
3. Every event detail (id, type, host, alert) will be inserted to HSQL in-memory DB.
4. Write found event details to file-based HSQLDB eventLogDb in the working folder.

----------------------------------------------------------------------------------
## How to Run :
  
  **Required s/w -** Java 1.8, Apache Maven, Git etc

1. Clone this repository to local system 
2. Build application by using command -> `mvn clean install`
3. Run the Application by -> `mvn spring-boot:run -Dspring-boot.run.arguments="{$test-file-path$}"`

   **Example** - mvn spring-boot:run -Dspring-boot.run.arguments="C://logfile.txt"
4. Analyse the application log & generated eventLogDb file for expected result
