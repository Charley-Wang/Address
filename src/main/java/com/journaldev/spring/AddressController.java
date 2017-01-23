package com.journaldev.spring;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Address;
import com.journaldev.spring.service.AddressService;
import com.journaldev.spring.service.CommentsService;

@Controller
public class AddressController {
	private AddressService addressService;
	private CommentsService commentsService;

	@Autowired(required=true)
	@Qualifier(value="addressService")
	public void setAddressService(AddressService as){
		this.addressService = as;
	}
	
	@Autowired(required=true)
	@Qualifier(value="commentsService")
	public void setCommentsService(CommentsService as){
		this.commentsService = as;
	}
	
	@RequestMapping(value="/address/create", method=RequestMethod.POST)
    public @ResponseBody String createAddress(@ModelAttribute(value="address") Address address, BindingResult result){
        String returnText;
        //if(!result.hasErrors()){
            // create date
        	address.setDate(new Date());
            returnText = "" + this.addressService.createAddress(address);
        //}else{
        //    returnText = "Sorry, an error has occur. User has not been added to list.";
        //}
        return returnText;
    }
	
	@RequestMapping(value="/address/find/{keys}/", method=RequestMethod.GET)
    public @ResponseBody String findAddress(@PathVariable("keys") String keys){
		List<Address> list = this.addressService.findAddress(keys);
		return appendTable(list);
    }
	
	private String appendTable(List<Address> list) {
		String ret = "";

		ret = "<tr>"
                  +"<td><strong>ID</strong></td>"
                  +"<td><strong>Address</strong></td>"
                  +"<td><strong>Score</strong></td>"
                  +"<td><strong>Type</strong></td>"
             +"</tr>";

		Iterator<Address> it = list.iterator();
		Address address;
		String tp;
		int ii = 0;
		while (it.hasNext()) {
			address = it.next();
			
			tp = address.getType1();
			if (!address.getType2().trim().equals("")) {
				tp += ", " + address.getType2();
			}
			
			ii++;
			ret += "<tr id='row" + ii + "'>"
                       + "<td id='ai'>" + address.getAddrID() + "</td>"
	                   + "<td>" + address.getAddress1() + ", " + address.getAddress2() + "</td>"
                       + "<td>" + this.commentsService.getAvgLevel(address.getAddrID()) + "</td>"
                       + "<td>" + tp + "</td>"	
                       + "</tr>";
		}
		
		return ret;
	}
	
	@RequestMapping(value="/address/search/{keys}/", method=RequestMethod.GET)
    public @ResponseBody String searchAddress(@PathVariable("keys") String keys){
		List<Address> list = this.addressService.searchAddress(keys);
		return appendTable(list);
    }
}


