package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthService implements IAuthService {
	@Autowired
	UserRepository userDao;

	@Override
	public User get(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(User userInfo) {
		log.info(userInfo.toString());
		User searchUser = userDao.findByUserId(userInfo.getUserId());
		if (searchUser != null) {
			log.info(searchUser.toString());
			if (searchUser.getUserPassword().equals(userInfo.getUserPassword())) {
				log.info("인증 성공");
				return true;
			} else {
				log.info("인증 실패..!!");
				return false;
			}
		} else {
			return false;
		}
	}

}
