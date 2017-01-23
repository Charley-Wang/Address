package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Address;

public interface AddressService {
	public long createAddress(Address address);
	public List<Address> findAddress(String keys);
	public List<Address> searchAddress(String keys);
}
