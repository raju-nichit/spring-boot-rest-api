package com.programmingkida.restfulwebservices.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.programmingkida.restfulwebservices.beans.User;

@Service
public class UserDao {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 4;

	 static{
		users.add(new User(1, "Raju", LocalDateTime.now()));
		users.add(new User(2, "Rutuja", LocalDateTime.now()));
		users.add(new User(3, "Govind", LocalDateTime.now()));
		users.add(new User(4, "Bharat", LocalDateTime.now()));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User save(User user){
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;	
	}
	
	
	public User findOne(int id) {
			Optional<User> user=users.stream().filter(obj->obj.getId()==id).findFirst();
			return user.isPresent() ? user.get() :null;
	}

}
