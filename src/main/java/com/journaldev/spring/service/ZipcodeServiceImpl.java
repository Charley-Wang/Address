package com.journaldev.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ZipcodeDAO;
import com.journaldev.spring.model.Zipcode;

@Service
public class ZipcodeServiceImpl implements ZipcodeService {

	private ZipcodeDAO zipcodeDAO;
		
	public void setZipcodeDAO(ZipcodeDAO zipcodeDAO) {
		this.zipcodeDAO = zipcodeDAO;
	}

	@Override
	@Transactional
	public void loadZipcodes() {
		this.zipcodeDAO.loadZipcodes();
	}

	@Override
	@Transactional
	public Zipcode getZipcode(String zip) {
		return this.zipcodeDAO.getZipcode(zip);
	}
}
