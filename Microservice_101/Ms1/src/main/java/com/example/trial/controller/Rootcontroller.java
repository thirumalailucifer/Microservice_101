package com.example.trial.controller;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import com.example.trial.model.User;
import com.example.trial.model.Uservalidate;

@Controller
public class Rootcontroller implements ErrorController{
    
	
	final String url="http://Ms2/adduser";
	//RestTemplate restTemplate=new RestTemplate();
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Inside /.jsp sending request to microservice1");
		return "login.jsp";
	}
	
	//Registration
	@RequestMapping(value="/registration")
	public String register() {
		return "registration.jsp";
	}
	
	//Sending data to DB
	@RequestMapping(value="/add")
	public String add(User user)
	{
		try {
		System.out.println("The entered details are"+user.getUid()+""+user.getPassword()+""+user.getUname());
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		entity = new HttpEntity<>(user,headers);
		ResponseEntity<String> r =   restTemplate.exchange("http://Ms2/adduser", HttpMethod.POST, entity, String.class);
        System.out.print("value of R"+r);
		}
		//restTemplate.postForObject(url, user, User.class);
		catch(Exception e) {
		System.out.println("Data stored successfully in H2");
		}
		return "registrationsuccess.jsp";
	}
	
	//Validation
	@RequestMapping(value="/msonevalidate")
	public String validation(Uservalidate uservalidate) {
		String c="true";
		System.out.println("The validation details are"+uservalidate.getUid()+""+uservalidate.getPassword());
		HttpHeaders headers1 = new HttpHeaders();
		headers1.setContentType(MediaType.APPLICATION_JSON);
		headers1.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity1 = new HttpEntity<>(headers1);
		entity1 = new HttpEntity<>(uservalidate,headers1);
		ResponseEntity<String> b =   restTemplate.exchange("http://Ms2/validateboolean", HttpMethod.POST, entity1, String.class);
		System.out.println("The boolean value from the body is"+b.getBody());
		System.out.println("The type of boolean value is"+b.getBody().getClass());
		if(b.getBody().equals(c)) {
			System.out.println("Authentication Success");
			return "loginsuccess.jsp";
		}
		else {
			System.out.println("Authentication Failed");
			return "loginfailed.jsp";
		}
		}

	@RequestMapping("/error")
	public String errorr() {
		System.out.println("Inside /test()");
		return "error.jsp";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

