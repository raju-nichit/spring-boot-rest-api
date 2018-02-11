package com.programmingkida.restfulwebservices.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programmingkida.restfulwebservices.beans.User;
import com.programmingkida.restfulwebservices.dao.UserDao;
import com.programmingkida.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<User> retiveAllUsers() {
		return userDao.findAll();
	}

	// input-details of user

	@GetMapping("/users/{id}")
	public Resource<User> retiveUser(@PathVariable Integer id) {

		User user = userDao.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retiveAllUsers());
		resource.add(linkTo.withRel("all-user"));
		
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);
		URI resourceURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(resourceURI).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User deletedUser = userDao.deleteUserById(id);
		if (deletedUser == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}
}
