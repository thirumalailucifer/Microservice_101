package com.example.trial.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.trial.dao.Userrepo;
import com.example.trial.model.User;
import com.example.trial.model.Uservalidate;

@Controller
public class UserController implements ErrorController {
    
	@Autowired
	Userrepo repo;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Inside index.jsp");
		return "index.jsp";
    }
	
	//Adding the data into the Database
	//@RequestMapping("/adduser")
	@PostMapping("/adduser")
	public String adduser(@RequestBody User user) {
		System.out.println("Inside Microservice 2");
		repo.save(user);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/add")
				 .buildAndExpand()
				 .toUri();
		System.out.println("Data Saved Successfully (check db)"+user.getUid()+user.getPassword()+user.getUname());
		return "home"; //return request Entity
	}
	
	//Fetching the data from the Database
	@PostMapping("/validateboolean")
	public ResponseEntity<Boolean> getboolean(@RequestBody Uservalidate uservalidate) {
		System.out.println("The received details for"
				+ ""+uservalidate.getUid()+""+uservalidate.getPassword());
		/*URI path = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/add")
				 .buildAndExpand()
				 .toUri();*/
		URI uRI = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		//Saving the details received
	    int uid=uservalidate.getUid();
	    String password=uservalidate.getPassword(); 
	    Boolean boolval=false;
		if(repo.existsById(uid)) {
			System.out.println("Inside Loop1");
			User user=repo.findById(uid).get();
			  System.out.println("User Object"+user);
			  System.out.println("User Id"+user.getUid()+"User Password"+user.getPassword());
		      boolval=(user.getPassword().equals(password));
		      //System.out.println("Authentication Status"+boolval);
		      return ResponseEntity.created(uRI).body(boolval);
		}
		return ResponseEntity.created(uRI).body(boolval);
	}
	
	@PostMapping("/validatebooleantest")
	public String getbooleantest(Uservalidate uservalidate)
	{
		System.out.println("The recieved credentials are"+uservalidate.getUid()+" "+uservalidate.getPassword());
		int uid=uservalidate.getUid();
		String password=uservalidate.getPassword();
		Boolean boolval=false;
		if(repo.existsById(uid)) {
			System.out.println("Inside Loop1");
			User user=repo.findById(uid).get();
			/*System.out.println("User Object"+user);
			  System.out.println("User Id"+user.getUid()+"User Password"+user.getPassword());*/
		      boolval=(user.getPassword().equals(password));
		      System.out.println("Authentication Success"+boolval);
		return "Test method to check the credentials";
}
		else {
			System.out.println("The boolean value is"+boolval);
		}
		return "Test method";
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