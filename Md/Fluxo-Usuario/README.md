# User Mapping
#### [Swagger](http://localhost:8080/swagger-ui/index.html) <br> [Postman Documentation](https://documenter.getpostman.com/view/38340143/2sAY4vi3vF)👨🏾‍🔧 <br> [Ler em Português](portuguese.md)

### <div align="center"> User Controller</div><br>

#### Recieves an `GET` request to `FIND` all the users registered. 
##### `Error Handling:` 
---
<img src="images/findAll.png">

<br>

#### Recieves an `GET` request to `FIND` the user registered based on the provided id.
##### `Error Handling:` 
---
<img src="images/findById.png">

<br>

#### Recieves an `POST` request to `REGISTER` user and returns the user registered.
##### `Error Handling:` If the user tries to `REGISTER` and a user with the same information already exists, the system will return a message informing that the user already exists in the database.
---
<img src="images/createUser.png">

<br>

#### Recieves an `DELETE` request to delete the user based on the provided login and returns a successful deletion confirmation.
##### `Error Handling:` Or, if an error occurs, the system will return the inability to delete with the error justification.  
---
<img src="images/deleteUser.png">
</div>

### <div align="center"> Postman Documentation under maintenance </div>

<div align="center">

👨🏾‍🔧[Postman Documentation](https://documenter.getpostman.com/view/38340143/2sAY4vi3vF)👨🏾‍🔧

#### All API testing and operations can be accessed through the Postman documentation link.<br>When you click to start the program, access the mapping using the website above.
</div>

###### <br><br><div align="right">Exception handling documentation will be updated furthermore</div>
