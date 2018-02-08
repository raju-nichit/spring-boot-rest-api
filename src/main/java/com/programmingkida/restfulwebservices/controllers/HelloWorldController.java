package com.programmingkida.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	
	@GetMapping(path="/hello-world-path-varible/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		  return new  HelloWorldBean(String.format("Hello world, %s",name));
	  }
	
	
	@GetMapping(path="/hello-world-query-param")
	public HelloWorldBean helloWorldQueryParam(@RequestParam("name") String name){
	  return new  HelloWorldBean(String.format("Hello world, %s",name));
  }
	
}
