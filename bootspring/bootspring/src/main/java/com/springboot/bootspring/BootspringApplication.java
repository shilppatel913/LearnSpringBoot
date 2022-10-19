package com.springboot.bootspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//below annotation is the combination of three annotations Configuration,enableAutoConfig,ComponentScan
//this is the starting point of your project

@SpringBootApplication
public class BootspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootspringApplication.class, args);
		
	}

}
