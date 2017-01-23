package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Zipcode;
import com.journaldev.spring.service.ZipcodeService;

@Controller
public class ZipcodeController {

	private ZipcodeService zipcodeService;

	@Autowired(required=true)
	@Qualifier(value="zipcodeService")
	public void setZipcodeService(ZipcodeService zs){
		this.zipcodeService = zs;
	}

	@RequestMapping(value="/loadZipcodes", method=RequestMethod.GET)
    public @ResponseBody String loadZipcodes(){
		this.zipcodeService.loadZipcodes();
        return "good";
    }
    
    @RequestMapping(value="/getLatLng/{zipcode}", method=RequestMethod.GET)
    public @ResponseBody String getLocation(@PathVariable("zipcode") String zip){
        Zipcode zipcode = this.zipcodeService.getZipcode(zip);
    	if (zipcode == null) return "";
    	else return zipcode.getLat() + "," + zipcode.getLng()
    	     + "," + zipcode.getCity() + "," + zipcode.getState();
    }
}