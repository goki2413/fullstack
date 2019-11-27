package com.demo.service;

import com.demo.model.User;

public interface UserService {
User createUser(User user);
User readUserById(int userId);
User readUseByName(String name);
User updateUser(User user);
boolean deleteUserById(int id);
}
