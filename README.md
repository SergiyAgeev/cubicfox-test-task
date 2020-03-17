### CUBICFOX-TEST-TASK
![](https://jirasupport.files.wordpress.com/2019/09/api-rest-1.png?w=579)

![](https://img.shields.io/github/languages/top/SergiyAgeev/internetmarket)
![](https://img.shields.io/github/languages/code-size/SergiyAgeev/internetmarket)
# Table of Contents
[Project purpose](#purpose)

[Project structure](#structure)

[For developer](#developer-start)

[Author](#author)


# <a name="purpose"></a>Project purpose
This project is a realisation of **REST API**.
Where its main functionality is realized.
<hr>

Available functions for **ALL** users: 
 >- /inject **GET** ``` inject data into database```
 >- /authenticate **POST** ```authentication and get JWT ```
 >- /h2 **GET** ``` enter database console```
 >- /register **POST** ```register new user ```
 
 Available functions for users with a **USER** role only: 
 >- /user **GET** ```user list with basic information ```
 >- /user/{id} **GET** ```one user with basic information ```
 >- /products **GET** ```product list with basic information ```
 >- /products/{id} **GET**```one product with all informatin ```
 >- /products/{id} **PUT**``` update product information```
 >- /rate/{id} **POST**```rate product (0-10) ```
 
 Available functions for users with an **ADMIN** role only:
 >- /admin/user **GET**```user list with all information ```
 >- /admin/user/{id} **GET**```one user with all information ```
<hr>

# <a name="structure"></a>Project Structure
- Java 11
- Maven 4.0.0
- Spring Boot
- Spring Security
- Spring Data Jpa
- JWT
- Embedded H2 database
- RBAC
<hr>

# <a name="developer-start"></a>For developer
- Recommended to use **POSTMAN** for *HTTP* requests.   
- Open the project in your IDE.
- Add it as maven project.
- Import dependencies.
- Add sdk 11 in project structure.
- Run the project.

<hr>

input **/inject** in address bar to add some data into the database :

##### user with roles = ADMIN, USER
>-use this in method **POST** body (raw) with **/authenticate** request

        {
         "username":"sergiyageev@gmail.com", 
         "password":"1234"
         }         
for response you will get **JWT**(example)
        
         "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZXJnaXlhZ2VldkBnbWFpbC5jb20iLCJyb2xlcyI6WyJBRE1JTiIsIlVTRVIiXSwiaWF0IjoxNTg0NDc4MDcwLCJleHAiOjE1ODQ0ODE2NzB9.e2ukkLYfcWKfSZ6Qg5mULmIk7aaamnKxfnC7eE9nxDI"
use this **JWT** as value in **Header** with key **Authorization** of every request for **authenticate** user(example)
![](https://i.imgur.com/lGm3lBi.png)
use **Bearer_** prefix before **JWT** 
<hr>

####Pagination
**default** pagination values is: **start** from page = 0, **limit** values on page = 20

     /products?page=YOUR_VALUE&limit=YOUR_LIMIT_VALUE
you can make changes with your own values
<hr>

####Filter
 you can filter products by product code
 
     /products?code=YOUR_SEARCHING_CODE
 input full code or part of code to find products
 <hr> 
 
####Update  
For update product, in method body use format like(example):

        {
            "code": "000000",
            "name": "00000000000",
            "description": "000000000",
            "status": "NOT_ACTIVE',
            "price": 0.11
        }
status can be only: **ACTIVE, NOT_ACTIVE, DELETED**
#
        

# <a name="author"></a>Author
 [SergiyAgeev](https://github.com/SergiyAgeev)