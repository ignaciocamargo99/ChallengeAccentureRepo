# Challenge Accenture
[![Java](https://blog.nebrass.fr/wp-content/uploads/java-logo-1.png)](https://nodesource.com/products/nsolid) 
Challenge Accenture is a project whose objective is to consume an external service use its information through an API. 
The external service with the data and routes is located at: https://jsonplaceholder.typicode.com

## Features 📋
- Access to users.
- Access to user photos.
- Access to comments, filter by name or user who publish the comment.

## Instalation and run ⚙️
To run the project you must have to download and install Tomcat (this is the server) and 
add it to the project after being cloned.

To run choose "Run as Spring Boot app".

## Languages and frameworks  🛠️

- [Springboot](https://spring.io/projects/spring-boot)
- [Java EE](https://docs.oracle.com/en/java/)

## IDE  🛠️
- [Eclipse](https://www.eclipse.org/)

## How to use? 🔧

To use the API you have 5 endpoints in port 8080:
- GET /users
- GET /comments
- GET /userPhotos?userId=1
- GET /commentsByName?name=quo%20vero%20reiciendis%20velit%20similique%20earum
- GET /commentsByUser?userId=1

You can send other values in the parameters as long as you respect the type of data that is required.

An extra endpoint maps errors when exception is 404:
- /error

Handled request exceptions are Not Found(404) and Bad Request(400).

## Authors ✒️
API Developer: Ignacio Ramiro Camargo Sotomayor.
Project proposed by: Accenture/Wolox Team.


