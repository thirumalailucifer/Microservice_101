package com.example.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AssignmentAlpha13Application {
    //Microservice 2
	public static void main(String[] args) {
		SpringApplication.run(AssignmentAlpha13Application.class, args);
	}

}
