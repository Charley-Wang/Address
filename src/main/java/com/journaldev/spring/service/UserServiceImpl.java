package com.journaldev.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
		
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void createUser(User user) {
		this.userDAO.createUser(user);
	}

	@Override
	@Transactional
	public boolean existEmail(String email) {
		return this.userDAO.existEmail(email);
	}

	@Override
	@Transactional
	public String login(String email, String password) {
		return this.userDAO.login(email, password);
	}

	@Override
	@Transactional
	public String findPassword(String email) {
		return this.userDAO.findPassword(email);
	}

	@Override
	@Transactional
	public String changePassword(String email, String oldPass, String newPass) {
		return this.userDAO.changePassword(email, oldPass, newPass);
	}

	@Override
	@Transactional
	public String deleteAccount(String email, String password, String message) {
		return this.userDAO.deleteAccount(email, password, message);
	}

	@Override
	@Transactional
	public String contact(String email, String message) {
		return this.userDAO.contact(email, message);
	}
}
