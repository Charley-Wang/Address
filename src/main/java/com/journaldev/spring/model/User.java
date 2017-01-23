package com.journaldev.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "userID")
	private String userID;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "state")
	private int state;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "notice")
	private boolean notice;
	
	public User() {
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String id) {
		this.userID = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isNotice() {
		return notice;
	}

	public void setNotice(boolean notice) {
		this.notice = notice;
	}
}
