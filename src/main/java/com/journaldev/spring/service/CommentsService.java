package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Comments;

public interface CommentsService {
	public void addComments(Comments comments);
	public List<Comments> findComments(String addrID);
	public double getAvgLevel(long addrID);
}
