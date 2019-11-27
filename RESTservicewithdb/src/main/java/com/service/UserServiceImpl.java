package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.model.User;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userdao;
	
	@Transactional
	@Override
	public User createUser(User user) {
	User user1=null;
		if(user.getUserName().length()>3){
			user1=this.userdao.createUser(user);
		}
		
		return user1;
	}

	
	@Override
	public List<User> readUser() {
	return this.userdao.readUser();
		
	}
	
	

	@Override
	public User readUserById(int userId) {
	
		return this.userdao.readUserById(userId);
	}
	
	

	@Override
	public User getUserByName(String userName) {
		User user=null;
		if(userName.length()!=0){
	      user=this.userdao.getUserByName(userName);
		}
		
		return user;
	}
	
	
	
	@Transactional
	@Override
	public User updateUser(User user) {
		User user1=null;
		if(user.getUserId()!=0){
			user1=userdao.updateUser(user);
		}
		return user1;
	}

	
	

	@Override
	@Transactional
	public User deleteById(int userId) {
		User user=null;
     if(userId!=0){
	user=this.userdao.deleteById(userId);
    }
		return user;
	}

    }
