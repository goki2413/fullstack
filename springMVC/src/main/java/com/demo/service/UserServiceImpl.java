package com.demo.service;

import org.springframework.stereotype.Service;
import com.demo.model.User;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readUserById(int userId) {
	User user=null;
	if(userId>0 && userId==10){
		user=new User();
		user.setUserId(10);
		user.setUserName("AAHA");
		
	}
	
	if(userId>0 && userId==20){
		user=new User();
		user.setUserId(20);
		user.setUserName("YAHA");
		
	}
	
	
		return user;
	}

	@Override
	public User readUseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
