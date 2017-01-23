package com.journaldev.spring.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Comments;

@Repository
public class CommentsDAOImpl implements CommentsDAO {

	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addComments(Comments comments) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(comments);
		session.flush();		
	}

	@Override
	public List<Comments> findComments(String addrID) {
		List<Comments> list = null;
		
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from comments where addrID=" + addrID;
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.Comments.class);
		list = query.list();
		
		return list;
	}

	@Override
	public double getAvgLevel(long addrID) {
		Session session = this.sessionFactory.getCurrentSession();

		String sql = "select * from comments where addrID=" + addrID;
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.Comments.class);

		int num = 0;
		double ret = 0;
		Iterator<Comments> it = query.list().iterator();
		Comments comment;
		
		while (it.hasNext()) {
			comment = it.next();
			num++;
			ret += comment.getLevel();
		}
		
		if (num == 0) ret = 0;
		else ret = ret / num;
		
		return ret;
	}

}
