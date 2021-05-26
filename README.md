# cs-assignment-event-log
-------------------------------------------------------------------------

## Summary - 

This is SpringBoot application with HSQL in-memory database.

1. This application takes log file in text format as input (command line argument) and process the log events.
   
   **Sample text log file location :** `src/main/resources/sampleLogEvent.txt`
3. application will flag `alert` for the events which takes more the 4ms for letion.
4. after processing event data, processed event detail (id, type, host and alert) will be inserted to HSQL in-memory DB.
5. Write found event details to file based HSQLDB `eventLogDb` file in the working folder.

----------------------------------------------------------------------------------
## How to Run :
  
  **Required s/w -** Java 1.8, Apache Maven, GitHub etc..

1. Clone `https://github.com/Sushil1810/cs-assignment-event-log.git` repository to local system. 
2. Build application by using command -> `mvn clean install`
3. Run the Application by -> `mvn spring-boot:run -Dspring-boot.run.arguments="{$test-file-path$}"`

   **Example** - `mvn spring-boot:run -Dspring-boot.run.arguments="C://logfile.txt"`
4. Analyse the `application logs` & generated `eventLogDb` file for expected result.
-----------------------------------------------------------------------------------------
## Result :
### 1. Application Logs :

`2021-05-26 18:51:26.236  INFO 6536 --- [           main] com.sushil.cs.Application                : Started Application in 4.614 seconds (JVM running fo
r 5.106)
2021-05-26 18:51:26.236  INFO 6536 --- [           main] com.sushil.cs.Application                : Given file path : C://logfile.txt
2021-05-26 18:51:26.236  INFO 6536 --- [           main] com.sushil.cs.Application                : Started processing on file C://logfile.txt
2021-05-26 18:51:26.236  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Start Event for Id : scsmbstgra
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Start Event for Id : scsmbstgrb
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Finish Event for Id : scsmbstgrc
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Finish Event for Id : scsmbstgra
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Start Event for Id : scsmbstgrc
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Convert JSON to EventDetails Object
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Finish Event for Id : scsmbstgrb
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Processing provided log data
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Converting EventDetails Obj to Event Entity Object f
or ID - scsmbstgra
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : converted event to entity for Event ID - scsmbstgra
2021-05-26 18:51:26.305  INFO 6536 --- [           main] com.sushil.cs.Application                : Saving Entity to HSql DB for Event ID : scsmbstgra
Hibernate: select evententit0_.id as id1_0_0_, evententit0_.alert as alert2_0_0_, evententit0_.duration as duration3_0_0_, evententit0_.host as host4_0_
0_, evententit0_.type as type5_0_0_ from event_entity evententit0_ where evententit0_.id=?
Hibernate: insert into event_entity (alert, duration, host, type, id) values (?, ?, ?, ?, ?)
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Saved Entity to HSql DB for Event ID :scsmbstgra
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Converting EventDetails Obj to Event Entity Object f
or ID - scsmbstgrb
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : converted event to entity for Event ID - scsmbstgrb
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Saving Entity to HSql DB for Event ID : scsmbstgrb
Hibernate: select evententit0_.id as id1_0_0_, evententit0_.alert as alert2_0_0_, evententit0_.duration as duration3_0_0_, evententit0_.host as host4_0_
0_, evententit0_.type as type5_0_0_ from event_entity evententit0_ where evententit0_.id=?
Hibernate: insert into event_entity (alert, duration, host, type, id) values (?, ?, ?, ?, ?)
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Saved Entity to HSql DB for Event ID :scsmbstgrb
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Converting EventDetails Obj to Event Entity Object f
or ID - scsmbstgrc
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : converted event to entity for Event ID - scsmbstgrc
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Saving Entity to HSql DB for Event ID : scsmbstgrc
Hibernate: select evententit0_.id as id1_0_0_, evententit0_.alert as alert2_0_0_, evententit0_.duration as duration3_0_0_, evententit0_.host as host4_0_
0_, evententit0_.type as type5_0_0_ from event_entity evententit0_ where evententit0_.id=?
Hibernate: insert into event_entity (alert, duration, host, type, id) values (?, ?, ?, ?, ?)
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Saved Entity to HSql DB for Event ID :scsmbstgrc
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Finished Processing data
2021-05-26 18:51:26.405  INFO 6536 --- [           main] com.sushil.cs.Application                : Application Started Successfully`

### 2. Generated eventLogDb.log (Database file):
`/*C1*/SET SCHEMA SYSTEM_LOBS
INSERT INTO BLOCKS VALUES(0,2147483647,0)
COMMIT
/*C2*/SET SCHEMA PUBLIC
drop table if exists event_entity CASCADE 
create table event_entity (id varchar(255) not null, alert boolean not null, duration bigint, host varchar(255), type varchar(255), primary key (id))
INSERT INTO EVENT_ENTITY VALUES('scsmbstgra',TRUE,5,'12345','APPLICATION_LOG')
COMMIT
INSERT INTO EVENT_ENTITY VALUES('scsmbstgrb',FALSE,3,NULL,NULL)
COMMIT
INSERT INTO EVENT_ENTITY VALUES('scsmbstgrc',TRUE,8,NULL,NULL)
COMMIT`

### 3. Screenshot:

![image](https://user-images.githubusercontent.com/33152557/119713882-d6df1400-be7f-11eb-9b8b-2cb1a5c88831.png)
