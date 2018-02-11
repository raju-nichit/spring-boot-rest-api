package com.programmingkida.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programmingkida.restfulwebservices.beans.User;
import com.programmingkida.restfulwebservices.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<User> retiveAllUsers(){
		return  userDao.findAll();
	}
	
	//input-details of user 
	
	@GetMapping("/users/{id}")
	public User retiveUser(@PathVariable Integer id){
		
		 User user = userDao.findOne(id);
		 if(user==null) {
			 throw new UserNotFoundException("id-"+id);
		 }
		 return user;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser=userDao.save(user);
	URI resourceURI = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(resourceURI).build();
	}
}
