package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Comments;

public interface CommentsDAO {
	public void addComments(Comments comments);
	public List<Comments> findComments(String addrID);
	public double getAvgLevel(long addrID);
}
