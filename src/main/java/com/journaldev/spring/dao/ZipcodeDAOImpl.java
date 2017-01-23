package com.journaldev.spring.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.util.Util;
import com.journaldev.spring.model.Zipcode;

@Repository
public class ZipcodeDAOImpl implements ZipcodeDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void loadZipcodes() {
		System.out.println("1");
		importData();		
	}

	@Override
	public Zipcode getZipcode(String zip) {
		Zipcode zipcode = null;

		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "SELECT * FROM zipcode where zipid = '" + zip.trim() + "'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.Zipcode.class);
		
		if (query.list().size() > 0) {
			zipcode = (Zipcode)query.list().get(0);
		}
		
		return zipcode;
	}
	
	/**
	 * import data from /resources/zip_lat_lng.csv file
	 */
	private void importData() {
		Map<String, String> dict = importCityState();
		
		String file = getPath() + "/resources/zip_lat_lng.csv";
		Session session = this.sessionFactory.getCurrentSession();
		BufferedReader in;
		String[] sc;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println(line);
				String[] txts = line.split(",");
				Zipcode zipcode = new Zipcode(txts[0].trim(),
						Double.valueOf(txts[1].trim()),
						Double.valueOf(txts[2].trim())
						);
				String zip = txts[0].trim();
				if (dict.containsKey(zip)) {
					sc = dict.get(zip).split(",");
					zipcode.setCity(sc[0]);
					zipcode.setState(sc[1]);
				} else {
					zipcode.setCity("");
					zipcode.setState("");
				}
				session.persist(zipcode);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, String> importCityState() {
		Map<String, String> dict = new HashMap<String, String>();
		String file = getPath() + "/resources/zipcode-primary.csv";
		String city;
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String[] txts = line.split(",");
				String zip = txts[0];
				for (int ii = 1; ii <= 5 - zip.length(); ii++) zip = "0" + zip;
				if (!dict.containsKey(zip)) {
					city = txts[1].toLowerCase();
					// city = city.substring(0, 1).toUpperCase() + city.substring(1);
					city = Util.capitalize(city);
					dict.put(zip, city + "," + txts[2]);
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dict;
	}
	
	private String getPath() {
    	String path = this.getClass().getClassLoader().getResource("").getPath();
    	String fullPath;
    	String pathArr[] = null;
    	
		try {
			fullPath = URLDecoder.decode(path, "UTF-8");
			pathArr = fullPath.split("/WEB-INF/classes/");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
    	return pathArr[0];
    }
}
