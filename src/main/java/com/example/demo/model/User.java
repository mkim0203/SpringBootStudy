package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	private @Id String userId;
	private String userPassword;

	public User() {
		super();
	}

	/**
	 * @param userId
	 * @param userPassword
	 */
	public User(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + "]";
	}

	
}
