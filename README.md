# Microservice_101
Built a small web application in Microservice Architecture managed under Netflix Eureka.


The application is built using Spring boot framework, HTML, JSP, H2 Database.

A simple web application which allows an user to create account and store user data it in H2 Database, further login with the credentials, Unlike monolithic architecture, in this application the functionalities are carried out by different microservices.

Microservice 1(Signup Service):

 - Signup funcitonality:Accepts a new User input as Java Object (POJO class mapping) and sends the user object to Microservice 2 using REST API.

- Signin funcitonality:Accept the user User credentials as Java Object (POJO class mapping) and sends the user object to Microservice 2 using REST API.

- Based on the boolean value returned from Microservice 2 authenticate user to login to the application.



Microservice 2(Validation Service):

- Receives the Java data Object and store it in H2 Database to fulfill signup operation.

- Validate the user credentials and returns back Boolean value to Microservice 1 if the login is successfull 0 if the login is unsuccessfull.

Microservices 1:

- Allows the user based on the boolean value returned from Microserive 2.


Future Security enhancements:

The application is vulnerable to Authentication Bypass an attacker can intercept the response from Microservice and manipulate the boolean value to login to the application the future versions this issue will be addressed.

##### I would like to thank Balaji and Ram vignesh for their Support.

Video Link : https://drive.google.com/file/d/1vOQ4lipOeSklr6Pqh5wgw6YrQ8XRJu3U/view?usp=drivesdk


