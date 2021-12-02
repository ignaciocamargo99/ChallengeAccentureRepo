package com.challenge.apirest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*") 
@RestController
@RequestMapping("/") 
public class ExternalApiController {
	
	static final String uri = "https://jsonplaceholder.typicode.com";
	
	@GetMapping("example")
	public ResponseEntity<Object> index(){
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("users")
	private String getUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String users = restTemplate.getForObject(uri + "/users", String.class);
		return users;
	}
	
	@GetMapping("comments")
	private String getComments() {
		RestTemplate restTemplate = new RestTemplate();
		String comments = restTemplate.getForObject(uri+ "/comments", String.class);
		return comments;
	}

}
