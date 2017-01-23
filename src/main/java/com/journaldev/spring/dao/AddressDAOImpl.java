package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Address;
import com.journaldev.spring.util.Util;

@Repository
public class AddressDAOImpl implements AddressDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public long createAddress(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(address);
		session.flush();
		return address.getAddrID();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddress(String keys) {
		List<Address> list = null;
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql = "select * from address where ";
		String[] keys2 = keys.split(",");
		for (int ii = 0; ii < keys2.length; ii++) {
			sql += "(address1 LIKE '%" + keys2[ii] + "%' OR address2 LIKE '%" + keys2[ii] + "%') AND";
		}
		sql += " (1 = 1)";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.Address.class);
		list = query.list();
		
		return list;
	}

	private String getValue(String input) {
		String ret = "";
		String[] tt = input.split("=");
		if (tt.length == 2) ret = tt[1].trim();
		return ret;
	}
	
	@Override
	public List<Address> searchAddress(String keys) {
		// lat=&lng=&address=&miles=&type1=&type2=null&state=
		List<Address> list = new ArrayList<Address>();
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println(keys);
		String[] txts = keys.split("&");
		
		String lat_txt = getValue(txts[0]);
		String lng_txt = getValue(txts[1]);
		String address = getValue(txts[2]);
		String miles_txt = getValue(txts[3]);
		String type1 = getValue(txts[4]);
		String type2 = getValue(txts[5]);
		String state = getValue(txts[6]);
		
		double miles = 0;
		double lat = 0, lng = 0;
		boolean withMiles = true;
		
		if (miles_txt.equals("") || miles_txt.equals("null")) {
			withMiles = false;
		} else {
			try {
				miles = Double.valueOf(miles_txt);
			} catch (Exception e) {
				withMiles = false;
			}
		}
		
		if (lat_txt.equals("") || lat_txt.equals("null")) {
			withMiles = false;
		} else {
			try {
				lat = Double.valueOf(lat_txt);
			} catch (Exception e) {
				withMiles = false;
			}
		}
		
		if (lng_txt.equals("") || lng_txt.equals("null")) {
			withMiles = false;
		} else {
			try {
				lng = Double.valueOf(lng_txt);
			} catch (Exception e) {
				withMiles = false;
			}
		}
		
		String sql = "select * from address where ";
		
		if (!(address.equals("") || address.equals("null"))) {
			sql += "(address1 LIKE '%" + address + "%' OR address2 LIKE '%" + address + "%') AND";
		}
		
		if (!(type1.equals("") || type1.equals("null"))) {
			sql += " type1 = '" + type1 + "' AND";
		}
		
		if (!(type2.equals("") || type2.equals("null"))) {
			sql += " type2 = '" + type2 + "' AND";
		}
		
		if (!(state.equals("") || state.equals("null"))) {
			sql += " state = '" + state + "' AND";
		}

		sql += " 1=1";
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(com.journaldev.spring.model.Address.class);
		
		Address addr;
		double lat2, lng2, dist;
		if (!withMiles) {
			list = query.list();
		} else {
			Iterator<Address> it = query.list().iterator();
			while (it.hasNext()) {
				addr = it.next();
				if (Double.valueOf(addr.getLat())!=null) {
					lat2 = addr.getLat();
					lng2 = addr.getLng();
					dist = Util.distance(lat, lng, lat2, lng2, "M");
					System.out.println(lat + ", " + lng + ", " + lat2 + ", " + lng2);
					System.out.println(miles + ", " + dist);
					if (dist <= miles) list.add(addr);
				}
			}
		}
		
		return list;
	}

}
