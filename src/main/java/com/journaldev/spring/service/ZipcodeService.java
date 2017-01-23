package com.journaldev.spring.service;

import com.journaldev.spring.model.Zipcode;

public interface ZipcodeService {
	public void loadZipcodes();
	public Zipcode getZipcode(String zip);
}
