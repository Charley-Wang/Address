package com.journaldev.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	@Column(name="commID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long commID;
	
	private long addrID;
	private String email;
	private Date date;
	private String comments;
	private int level;
	public long getCommID() {
		return commID;
	}
	public void setCommID(long commID) {
		this.commID = commID;
	}
	public long getAddrID() {
		return addrID;
	}
	public void setAddrID(long addrID) {
		this.addrID = addrID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
