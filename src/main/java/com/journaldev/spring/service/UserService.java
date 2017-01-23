package com.journaldev.spring.service;

import com.journaldev.spring.model.User;

public interface UserService {
	public void createUser(User user);
	public boolean existEmail(String email);
	public String login(String email, String password);
	public String findPassword(String email);
	public String changePassword(String email, String oldPass, String newPass);
	public String deleteAccount(String email, String password, String message);
	public String contact(String email, String message);
}
