package com.example.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class AssignmentAlpha12Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentAlpha12Application.class, args);
	}

}
