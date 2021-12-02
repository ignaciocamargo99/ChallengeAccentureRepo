package com.challenge.apirest.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("*") 
@RestController
@RequestMapping("/") 
public class ExternalApiController {
	static final String uri = "https://jsonplaceholder.typicode.com";
	
	@GetMapping("users")
	private String getUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String users = restTemplate.getForObject(uri + "/users", String.class);
		return users;
	}
	
	@GetMapping("comments")
	private String getComments() {
		RestTemplate restTemplate = new RestTemplate();
		String comments = restTemplate.getForObject(uri + "/comments", String.class);
		return comments;
	}
	
	@GetMapping("userPhotos")
	private String getUserPhotos(@RequestParam String userId){
		RestTemplate restTemplate = new RestTemplate();
		String albumUser = restTemplate.getForObject(uri + "/albums?userId=" + userId, String.class);
		JSONArray albums = new JSONArray(albumUser);
		
		ArrayList<Integer> albumIds = new ArrayList<>(); 
		for(int i = 0; i < albums.length(); i ++) {
			JSONObject json = albums.getJSONObject(i);
			albumIds.add(json.getInt("id"));
		}
		
		String userPhotos = restTemplate.getForObject(uri + "/photos?albumId=" + albumIds.get(0) 
		+ "&albumId=" + albumIds.get(1) + "&albumId=" + albumIds.get(2) + "&albumId=" + albumIds.get(3) +
		"&albumId=" + albumIds.get(4) + "&albumId=" + albumIds.get(5) + "&albumId=" + albumIds.get(6) +
		"&albumId=" + albumIds.get(7) + "&albumId=" + albumIds.get(8) + "&albumId=" + albumIds.get(9), String.class);
		
		return userPhotos;
	}
	
	@GetMapping("commentsByName")
	private String getCommentsByName(@RequestParam String name) {
		RestTemplate restTemplate = new RestTemplate();
		String commentsByName = restTemplate.getForObject(uri + "/comments?name=" + name, String.class);
		return commentsByName;
	}

}
