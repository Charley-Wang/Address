package com.journaldev.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.User;
import com.journaldev.spring.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}

	@RequestMapping(value="/users/adduser", method=RequestMethod.POST)
    public @ResponseBody String addUser(@ModelAttribute(value="user") User user, BindingResult result){
        String returnText;
        //if(!result.hasErrors()){
            // create date
        	user.setState(1);
        	user.setEmail(user.getEmail().trim().toLowerCase());
        	user.setDate(new Date());
        	this.userService.createUser(user);
            returnText = "OK";
        //}else{
        //    returnText = "Sorry, an error has occur. User has not been added to list.";
        //}
        return returnText;
    }
	
	@RequestMapping(value="/users/email/{email}/check", method=RequestMethod.GET)
    public @ResponseBody String existEmail(@PathVariable("email") String email){
        if (this.userService.existEmail(email)) return "exists";
        else return "OK";
    }

	@RequestMapping(value="/users/email/{email}/password/{password}/check", method=RequestMethod.GET)
    public @ResponseBody String login(@PathVariable("email") String email,
    		                          @PathVariable("password") String password){
        return this.userService.login(email, password);
    }
	
	@RequestMapping(value="/users/findemail/{email}/check", method=RequestMethod.GET)
    public @ResponseBody String findEmail(@PathVariable("email") String email){
        return this.userService.findPassword(email);
    }

	@RequestMapping(value="/users/newpass", method=RequestMethod.POST)
    public @ResponseBody String changePassword(@ModelAttribute(value="user") User user, BindingResult result){
		return this.userService.changePassword(user.getEmail(), user.getPassword(), user.getMessage());
    }
	
	@RequestMapping(value="/users/delaccount", method=RequestMethod.POST)
    public @ResponseBody String deleteAccount(@ModelAttribute(value="user") User user, BindingResult result){
		return this.userService.deleteAccount(user.getEmail(), user.getPassword(), user.getMessage());
    }
	
	@RequestMapping(value="/users/contact", method=RequestMethod.POST)
    public @ResponseBody String contact(@ModelAttribute(value="user") User user, BindingResult result){
		return this.userService.contact(user.getEmail(), user.getMessage());
    }
}
