#InComm QA Exam

##User Story:

As a User of the InComm QA Exam application, I need to be able to login successfully, 
so that I have access to the QA Exam application.


##Acceptance Criteria:	

**GIVEN** I have been provided with ACCURATE Login Credentials (username/password)  
**WHEN** I login to the InComm QA Exam application  
**THEN** I receive a LOGIN SUCCESS message on the screen

**GIVEN** I have been provided with INACCURATE Login Credentials (username/password)  
**WHEN** I login to the InComm QA Exam application  
**THEN** I receive a LOGIN FAILURE message on the screen


##Your Assignment:

Using SELENIUM webdriver, code a Test Class that utilizes a Page Object.   
The automated test will exercise/test the InComm QA Exam application's login screen (provided).  
All needed Java dependencies are included in the Maven pom file.  
Good Luck!!!


##Optional Bonus Task:
Using the data in the grid below, iterate through the data in your test


| Username | Password | Expected Condition | 
| ---- | ---- | ---- | 
| testUser | incomm_1 | Success | 
| anyUser | anyPass | Failure |