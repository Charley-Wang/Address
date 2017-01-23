package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Address;

public interface AddressDAO {
	public long createAddress(Address address);
	public List<Address> findAddress(String keys);
	public List<Address> searchAddress(String keys);
}
