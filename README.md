**How to start with Spring Boot**

1) Create a maven project and add starter dependencies(noobs do that)
2) Using Spiring Initializr
3)Using IDE like STS
4) Spring boot command line interface.

The spring initializr will give you a zip file which you can extract and simply open the maven project in your eclipse or any other IDE.
It will also have the tomcat server already configured in project so that we do not have to add it manually like we did spring MVC.


**Note**
When running the SpringBoot application an error might occur because you might have added some dependencies and when you run the application it will scan your classpath
which has all the jar files of your dependencies. It will activate it immediately and since we have not configured some things related to that dependency it will throw
an error. Hence only include those dependencies which you are going to use intially.


@SpringBootApplication annotation is the combination of three annotations.
1) @Configuration
2) @enableAutoConfiguration
3) @ComponentScan

**Where will you configure everything**
You can configure everything in the application.properties file.

**Important Note**
For the embedded tomcat to read the JSP pages just add the tomcat jasper dependency from the maven repository.


**JPA(Java Persistence API) in Spring Boot**
 JPA is way with the help of which you can connect your application to the database.
 Hibernate framework provides all the implementation of the JPA dependency. Other frameworks like OpenJPA , Eclipse Link also provides the implementation.
 We will use ORM for Object Relational Mapping so that we dont need to write queries or manually convert the object.
 Now if we want to map User class in the database we have to first create the model class that is User and define all the properties. After that we need to create one
 more database layer over that which is user defined and similar to the dao interface that we used to make known as UserRepository. This UserRepository interface will
 extend the CRUDINTERFACE to perform all the crud operations. We will use EntityManager to perform create,update,delete operations.


**Custom Finder**
We have seen some in built query related methods that the crud repository provides us. But what if we want to write custom queries and execute them according to our 
need. We can write customised methods for that. For example in the UserRepository interface which is a user defined interface and which extends another interface which is the CrudRepository we can write our own methods and data will be queried accordingly. There are different types for every variation. You need to mention the return type more precisely and the criteria or condition on which the data will be queried. Some of the examples are :
1) data by name
2) data by name and passsword
3) data by date
4) data by startswith condition
For more examples you can refer to the below link which has all the methods there are possible.
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details




**JPQL and Native Query**
Rather than using derived methods you can write a query and perform your operation.You will have to use the @Query annotation for that. 
1)JPQl is Java Persistence Query language which has different syntax than sql .
 @Query("select u from User u where u.userName=:n")
 public List<User> q1(@Param("n") String name)  //this n will be binded to the name variable and now you can use the function.
 
2) Native query
 This is our normal sql query 
  @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
  User findByEmailAddress(String emailAddress);
 
 
**Spring dev tools**
You can include the dependency of spring dev tools in your maven project to optimize your project creating experience. It has majorly 4 advantages
1) Property Defaults
  Sometimes even after changing a property of an element we do not see that change being reflected in our application.This is because our browser is loading our page from the cache and hence no new changes exist in that cache. Hence we need to set this property to false and dev tools automatically do that.
 
 2) Automatic Reloading
 3) Automatic Restart on adding any new software.
 4) Remote Applications

 
 
 
 
 **REST APIs**
 We use the Response Entity object to send back the status of the request that has been triggered by the client. We can send different status codes in a specific manner describing how the request was handled back on the server.


**Form Validation using Server side**
Usually we can validate the form at both the client as well as the server side. But sometimes the js at the client can be disabled by a user and hence no validation 
takes place at the client side. Hence server side form validation is important.We have to use two dependencies bean-validation api and hibernate validator and to 
activate them we have to make use of @Valid annotation in the controller class. Different annotations such as @NotBlank, @Size, @Pattern(regex="") in the entity class
for the validation purpose which are being provided by the hibernate validator dependency. After entering the data in the form if any invalid data has been entered , it is stored inside the BindingResult object. And you can show all the errors with the help of it on the server side and on the client side as well in a well mannered fashion.


