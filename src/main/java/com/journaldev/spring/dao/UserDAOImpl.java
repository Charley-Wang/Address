package com.journaldev.spring.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void createUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
	}

	@Override
	public boolean existEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() > 0) return true;
		else return false;
	}

	@Override
	public String login(String email, String password) {
		String ret = "OK";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() <= 0) {
			ret = "There is no email in this system!";
		} else {
			User user = (User)query.list().get(0);
			ret += user.getUserID();
			if (!user.getPassword().equals(password.trim())) {
				ret = "Email and password do not match!";
			}
		}
		
		return ret;
	}

	@Override
	public String findPassword(String email) {
		String ret = "OK";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() <= 0) {
			ret = "There is no email in this system!";
		} else {
			User user = (User)query.list().get(0);
			user.setMessage("NEED PASSWORD " + user.getMessage());
			session.update(user);
			session.flush();
		}
		
		return ret;
	}

	@Override
	public String changePassword(String email, String oldPass, String newPass) {
		String ret = "OK";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() <= 0) {
			ret = "There is no email in this system!";
		} else {
			User user = (User)query.list().get(0);
			if (user.getPassword().equals(oldPass.trim())) {
				user.setPassword(newPass.trim());
				session.update(user);
				session.flush();
			} else {
				ret = "Email and password do not match!"; 
			}
		}
		
		return ret;
	}

	@Override
	public String deleteAccount(String email, String password, String message) {
		String ret = "OK";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() <= 0) {
			ret = "There is no email in this system!";
		} else {
			User user = (User)query.list().get(0);
			if (user.getPassword().equals(password.trim())) {
				user.setState(0);
				user.setMessage("DELETE " + message + " " + user.getMessage());
				session.update(user);
				session.flush();
			} else {
				ret = "Email and password do not match!"; 
			}
		}
		
		return ret;
	}

	@Override
	public String contact(String email, String message) {
		String ret = "OK";
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from user where email='" + email.trim().toLowerCase() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.User.class);

		if (query.list().size() <= 0) {
			ret = "There is no email in this system!";
		} else {
			User user = (User)query.list().get(0);
			user.setMessage("CONTACT " + message + " " + user.getMessage());
			session.update(user);
			session.flush();
		}
		
		return ret;
	}
}