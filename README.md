# cybus-performance-test

Project Description:
This performance testing project tests Currency Converter API performance.
Test data are given in ..\cybus-performance-test\src\test\resources\data\testdata.csv file. You can change/add more test cases.
Application data such as Base URL, API Key, API Host, Number of User and Test Duration are given in ..\cybus-performance-test\src\test\resources\application.properties file
The Test Simulation Script is in ..\cybus-performance-test\src\test\scala\CurrencyConverterAPITest.scala file

IMPORTANT: Please change the API Key before running the project. This Currency Converter API is NOT Free. It charges when there is 100+ requests per day. Another important thing is Number of User and Test Duration is configurable and now number of user is small and duration is large because this API can not server many request at a time.

Clone Project: git clone https://github.com/Sanam7044/cybus-performance-test.git
Go to project root directory: cd cybus-performance-test

How to run the project on your local machine:
From project root directory: 
1. mvn clean test (it will clean the target folder if there is already any and then download all the dependancys)
2. mvn gatling:test -D"gatling.simulationClass=CurrencyConverterAPITest"  (it will run our performance test simulation)

You will get the test report under: ..\cybus-performance-test\target\gatling\..\index.html

Requirements for running from local machine:
Apache Maven 3.8.6
java version "18.0.1.1"
Scala 3.2.1

How to run the project in a Docker:
From Project Root Directory open a command promt
From command promt, Build Docker Image: docker build -t cybus-performance-test:latest .

Run the image in a container + open an interactve bash terminal:
docker run -it --name cybus-performance-test-container cybus-performance-test:latest /bin/bash

From the bash terminal run the test project:
mvn gatling:test -D"gatling.simulationClass=CurrencyConverterAPITest"  

Requirements for running :
A docker should be available

Tool Selection: For performance test of the given API, I have selected Gatling as it is powerful open-source performance testing tool considering following criteria:
1.	Gatling can create millions of virtual users with less CPU, memory usage. Gatlin is distributed message driven application instead of thread like other tools (JMeter) which allows it to create 50 million of user at a time where thread-based performance testing tools have a limitation.
2.	Script based tool that makes it easy to integrate with version control system, CI/CD pipeline.
3.	Scripts can be written in Java, Scala or Kotlin.
4.	Colorful report.
Performance test Scenario: As a performance test scenario, I want to see how application behaves when there are many users accessing the API at a time. I will observe:
1.	The response time.
2.	 And the stability which means whether the API is stable when certain user simultaneously accessing it.

