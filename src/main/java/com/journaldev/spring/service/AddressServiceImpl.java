package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.AddressDAO;
import com.journaldev.spring.model.Address;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressDAO addressDAO;
	
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	
	@Override
	@Transactional
	public long createAddress(Address address) {
		return this.addressDAO.createAddress(address);		
	}

	@Override
	@Transactional
	public List<Address> findAddress(String keys) {
		return this.addressDAO.findAddress(keys);
	}

	@Override
	@Transactional
	public List<Address> searchAddress(String keys) {
		return this.addressDAO.searchAddress(keys);
	}
}