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
 We will use ORM for Object Relational Mapping so that we dont need to write queries or manually conver the object.
 Now if we want to map User class in the database we have to first create the mode class that is User and define all the properties. After that we need to create one
 more database layer over that which is user defined and similar to the dao interface that we used to make known as UserRepository. This UserRepository interface will
 extend the CRUDINTERFACE to perform all the crud operations. We will use EntityManager to perform create,update,delete operations.



