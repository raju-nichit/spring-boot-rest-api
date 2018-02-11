package com.programmingkida.restfulwebservices.beans;

import java.time.LocalDateTime;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer id;

	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	@Past(message = "Date should in the past")
	private LocalDateTime birthDate;

	public User() {

	}

	public User(Integer id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
