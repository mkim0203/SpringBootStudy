package com.example.demo.service;

import com.example.demo.model.User;

public interface IAuthService {
	public User get(String userId);

	public boolean checkUser(User userInfo);
}
