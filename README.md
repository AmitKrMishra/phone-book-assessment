# Task:
Create a simple phone book application using the technologies & patterns that you feel best show your technical knowledge. What we are looking for is any type of front end that can post a payload to an API and make its way to a database. The goal is to showcase your abilities.  

This repository holds projects that together comprise the Phone Book Backend and Frontend for the Assessment.

## Build Prerequisites

* JDK 1.8
* Spring STS 3.8.x (https://spring.io/tools/sts/all) 
* Git Shell (https://git-for-windows.github.io/) or SourceTree (https://www.sourcetreeapp.com/) for Cloning & pushing the code changes. 
* Maven 3.x
* Proxy setup to download dependencies from open source repositories
* Open Source or GitShell Command Line Interface

## Build Instructions

1. Browse to your preferred directory and run below command:

    git clone https://github.com/AmitKrMishra/phone-book-assessment.git

2. Build via this command:
   
    mvn clean install

3. Run

   mvn spring-boot:run
   
Architecture Description:
-------------------------
phone-be: Is the backend API used to perform insert and list operation to in inbuilt cache memory.
phone-fe: Is the front end spring boot web application, makes call to phone-be api to perform the crud operation.

## Use full URL
* Database URL
     localhost:8080/h2-console

* phone-be (Phone Back End API)
     localhost:8080/swagger-ui.html#/

* phone-fe (Phone Fron End Web application)
     http://localhost:9001/index.html

## How do I get set up?

* Summary of set up
* Configuration
* Dependencies
* Database configuration
  -
* How to run tests
* Deployment instructions

 

 













