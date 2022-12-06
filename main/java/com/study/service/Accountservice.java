package com.study.service;

import com.study.domain.User;
import com.study.repository.UserRepository;

public class Accountservice {

	private static Accountservice instance = null;

	private Accountservice() {}

	public static Accountservice getInstance() {
		if (instance == null) {
			instance = new Accountservice();
		}
		return instance;
	}

	public boolean isDuplicateUsername(String username) {
		User user = UserRepository.getInstance().findUserByUsername(username);
		return user != null;
	}
	
	public void register(User user) {
		UserRepository.getInstance().saveUser(user);
	}
	
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	
	public boolean checkPassword(User user, String password) {
		return user.getPassword().equals(password);
	}
}
