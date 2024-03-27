
# XpressBees-Assignment

Hi! This is an application for XpressBees API integration.

This program helps us to inreact with XpressBees APIs such as getAllCouriers, getTracking updates, etc.

This is developed in SpringBoot application and Java as a programming language.



## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer apprentice at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot, MySQL.


# Data Flow

## Controller Section

- This section contains a class that contanis API endpoints for accessing the application.

* ### CourierController Class

## Service Section

- This section contains classes which will help us to apply our logic on how our code interacts with the XpressBees apis.
- Now the XpressBees itself doesn't provide public apis for testing, so to overcome that issue I have used a third party service that helps us interact with XpressBees, the service is known as ShipRocked API.

* ### CourierService
* ### XpressBeesService

## API Guide

- Now this program contains multiple APIs, this section is a guide on how to setup and get running with the application.

- Firstly you need to have a token via which you can access ShipRocket APIs from our application, now the guide to create token is available at their offical API documentation site.

https://apidocs.shiprocket.in/#8a56b4d6-b418-43cf-be25-ead62532aa18

Now once you have created your token, you can put it in the application.properties file of the code with the format as

        app-token=your_token

Once the token is generated, you can simply run the available api endpoints to interact with our application. Below are some examples :

- Get All Courier API
  
  ![Screenshot 2024-03-27 161629](https://github.com/Nikhil-Sharma-CS/XpressBeesAssignment/assets/72157075/2c7780a4-1095-4608-9c09-6abfc70fd214)

- Get Tracking update via OrderId and ChannelId

  ![Track via Id](https://github.com/Nikhil-Sharma-CS/XpressBeesAssignment/assets/72157075/6f6c3c24-5a9d-465c-98b9-f9d776bd1b9c)

- Get Tracking update via AWB Number

  ![Track via AWB](https://github.com/Nikhil-Sharma-CS/XpressBeesAssignment/assets/72157075/54a5cb1c-a87d-4a8a-a9a4-d91af7a75e70)

- Create Order

  ![Create Order](https://github.com/Nikhil-Sharma-CS/XpressBeesAssignment/assets/72157075/d70beadd-48f9-477d-9250-d0051010d1d9)

For the above api, pass the json data in request body as per the format of object class in model section!


## Summary

*In summary, this application helps user to interact with the XpressBees APIs to perform different operations*

*It also uses unit tests cases to check the reliability and if the program is running as expected or not.*
## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)


