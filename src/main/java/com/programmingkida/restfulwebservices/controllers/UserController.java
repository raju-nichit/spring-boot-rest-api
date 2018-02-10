package com.programmingkida.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		return  userDao.findOne(id);
	}
	
	
}
