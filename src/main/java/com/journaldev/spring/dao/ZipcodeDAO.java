package com.journaldev.spring.dao;

import com.journaldev.spring.model.Zipcode;

public interface ZipcodeDAO {
	public void loadZipcodes();
	public Zipcode getZipcode(String zip);
}
