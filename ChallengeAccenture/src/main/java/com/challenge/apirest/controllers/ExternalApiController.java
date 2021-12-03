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

import com.challenge.apirest.utils.exceptions.BadRequestException;

@CrossOrigin("*") 
@RestController
@RequestMapping("/") 
public class ExternalApiController {
	static final String uri = "https://jsonplaceholder.typicode.com";
	
	@GetMapping("users")
	private String getUsers() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String users = restTemplate.getForObject(uri + "/users", String.class);
			return users;	
		}
		catch(Exception e){
			return e.getMessage();
		}
		
	}
	
	@GetMapping("comments")
	private String getComments() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String comments = restTemplate.getForObject(uri + "/comments", String.class);
			return comments;
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	@GetMapping("userPhotos")
	private String getUserPhotos(@RequestParam String userId){
		try {
			RestTemplate restTemplate = new RestTemplate();
			String userAlbum = restTemplate.getForObject(uri + "/albums?userId=" + userId, String.class);
			JSONArray albums = new JSONArray(userAlbum);
			
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
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("commentsByName")
	private String getCommentsByName(@RequestParam String name) {
		try {			
			RestTemplate restTemplate = new RestTemplate();
			String commentsByName = restTemplate.getForObject(uri + "/comments?name=" + name, String.class);
			return commentsByName;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("commentsByUser")
	private String getCommentsByUser(@RequestParam String userId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String userPosts = restTemplate.getForObject(uri + "/posts?userId=" + userId, String.class);
			
//			if(!userPosts.equals("")) {
				JSONArray posts = new JSONArray(userPosts);
				
				
				ArrayList<Integer> postsIds = new ArrayList<>(); 
				
				for(int i = 0; i < posts.length(); i ++) {
					JSONObject json = posts.getJSONObject(i);
					postsIds.add(json.getInt("id"));
				}
			
				
				String userComments = restTemplate.getForObject(uri + "/comments?postId=" + postsIds.get(0) 
				+ "&postId=" + postsIds.get(1) + "&postId=" + postsIds.get(2) + "&postId=" + postsIds.get(3) +
				"&postId=" + postsIds.get(4) + "&postId=" + postsIds.get(5) + "&postId=" + postsIds.get(6) +
				"&postId=" + postsIds.get(7) + "&postId=" + postsIds.get(8) + "&postId=" + postsIds.get(9), String.class);
				
				return userComments;	
//			}
		}
		catch(Exception e) {
			throw new BadRequestException("You must pass an INTEGER for the userId");
		}

	}
}
