package com.example.trial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AssignmentAlpha14Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentAlpha14Application.class, args);
	}

}
