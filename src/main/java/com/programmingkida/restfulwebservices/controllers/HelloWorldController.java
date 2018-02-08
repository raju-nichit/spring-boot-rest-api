package com.programmingkida.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingkida.restfulwebservices.beans.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
		public String helloWorld(){
		  return "Hello World";
	  }
	
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
	  return new HelloWorldBean("Hello World Bean");
	}
	
}
