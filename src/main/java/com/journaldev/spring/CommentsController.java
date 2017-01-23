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
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Address;
import com.journaldev.spring.model.Comments;
import com.journaldev.spring.service.CommentsService;

@Controller
public class CommentsController {

	private CommentsService commentsService;

	@Autowired(required=true)
	@Qualifier(value="commentsService")
	public void setCommentsService(CommentsService cs){
		this.commentsService = cs;
	}
	
	@RequestMapping(value="/comments/create", method=RequestMethod.POST)
    public @ResponseBody String addComments(@ModelAttribute(value="comments") Comments comments, BindingResult result){
        String returnText;
        //if(!result.hasErrors()){
            // create date
        	comments.setDate(new Date());
        	this.commentsService.addComments(comments);
            returnText = "OK";
        //}else{
        //    returnText = "Sorry, an error has occur. User has not been added to list.";
        //}
        return returnText;
    }
	
	@RequestMapping(value="/comments/addrID/{addrID}/", method=RequestMethod.GET)
    public @ResponseBody String findAddress(@PathVariable("addrID") String addrID){
		List<Comments> list = this.commentsService.findComments(addrID);
		return appendTable(list);
    }
	
	private String appendTable(List<Comments> list) {
		String ret = "";

		ret = "<tr>"
                  +"<td><strong>Date</strong></td>"
                  +"<td><strong>Score</strong></td>"
                  +"<td><strong>Comments</strong></td>"
             +"</tr>";

		Iterator<Comments> it = list.iterator();
		Comments comm;
		
		while (it.hasNext()) {
			comm = it.next();
			ret += "<tr>"
                       + "<td>" + comm.getDate().toString() + "</td>"
	                   + "<td>" + comm.getLevel() + "</td>"
                       + "<td>" + comm.getComments() + "</td>"
                 + "</tr>";
		}
		
		return ret;
	}
}
