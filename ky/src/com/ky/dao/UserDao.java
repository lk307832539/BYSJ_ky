package com.ky.dao;

import java.util.List;

import com.ky.entity.CarOwner;
import com.ky.entity.User;

public interface UserDao {
	//增加用户
	public void addUser(User user);

	public List<User> getAllUser();
	
	public boolean delUser(Integer id);
	
	public User getUser(Integer id);
	
	public User getUserByUserName(String userName);

	public void updateUser(User user);
	
	public User getUser(String userName, String password);

}
