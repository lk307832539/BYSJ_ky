package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.UserDao;
import com.ky.entity.CarOwner;
import com.ky.entity.User;
import com.ky.service.UserMng;
@Service
public class UserMngImpl implements UserMng{
	 @Resource
	  private UserDao userDao;

	@Override
	public User addUser(User user) {
		this.userDao.addUser(user);
		return null;
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = this.userDao.getAllUser();
		return list;
	}

	@Override
	public User delUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer id) {
		User user = this.userDao.getUser(id);
		return user;
	}

	@Override
	public User getUserByName(String userName) {
		User user = this.userDao.getUserByUserName(userName);
		return user;
	}

	@Override
	public User updateUser(User user) {
		this.userDao.updateUser(user);
		return null;
	}

	@Override
	public User getUser(String userName, String password) {
		User user = this.userDao.getUser(userName, password);
		return user;
	}
}
