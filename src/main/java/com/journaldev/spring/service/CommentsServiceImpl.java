package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.CommentsDAO;
import com.journaldev.spring.model.Comments;

@Service
public class CommentsServiceImpl implements CommentsService {

	private CommentsDAO commentsDAO;
		
	public void setCommentsDAO(CommentsDAO commentsDAO) {
		this.commentsDAO = commentsDAO;
	}
		
	@Override
	@Transactional
	public void addComments(Comments comments) {
		this.commentsDAO.addComments(comments);
	}

	@Override
	@Transactional
	public List<Comments> findComments(String addrID) {
		return this.commentsDAO.findComments(addrID);
	}

	@Override
	@Transactional
	public double getAvgLevel(long addrID) {
		return this.commentsDAO.getAvgLevel(addrID);
	}

}
