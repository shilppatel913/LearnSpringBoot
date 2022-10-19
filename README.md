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



