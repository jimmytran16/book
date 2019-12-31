package cit285.book.service;


import java.util.ArrayList;

import cit285.book.dao.UserDao;

import cit285.book.domain.User;

public class UserServices implements UserServicesAPI {
	UserDao userDao;
	
	public UserServices() {
		userDao = new UserDao();
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<>(userDao.getUserInfo());
		return users;
	}
}