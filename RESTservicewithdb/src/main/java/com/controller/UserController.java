package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.IUserDao;
import com.model.User;
import com.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserDao userdao;
	@Autowired
	private IUserService userservice;
	
	
	@GetMapping(value="/readall")
	List<User>readAll() {
		return userdao.readUser();
	}
	
	
	@PostMapping(value="/create")
	public User createUser(@RequestBody User user){
		
		return  this.userservice.createUser(user);
		                                         //user info should come from postman (ui)
		
	}
	
	
	@GetMapping(value="/readbyid/{userId}")
	User readById(/*@RequestParam("userId")*/@PathVariable("userId") int userId){
		return userservice.readUserById(userId);

    }
	
	
	@GetMapping(value="/readbyname")
	User readById(@RequestParam("userName") String userName){
		return userservice.getUserByName(userName);

     }
	
	
	@DeleteMapping(value="/deletebyid")
	User deleteById(@RequestParam("userId") int userId){
		return this.userservice.deleteById(userId);
		
	}
	
	
	@PutMapping(value="/update")
	User updateUser(@RequestBody User user){
		return userservice.updateUser(user);
		
	}
	
    }