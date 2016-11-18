package com.neu.edu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.ExtendsQueueEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobDetailsDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	private String view;
	
	
	 
	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit(HttpServletRequest request, HttpServletResponse response,Model mv){
		System.out.println("Inside Login Controller");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//UserDAO userDao = new UserDAO();
		User userDetails = userDAO.searchUserName(userName);
		
		if(userDetails.getUserName().equals(userName)){
			if(userDetails.getPassword().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("userSession", userDetails);
		if(userDetails.getRole().equals("Admin"))
		{
			view = "admindashboard";
		}
		
		else if(userDetails.getRole().equalsIgnoreCase("Employee"))
		{


			view = "employeedashboard";
		}
		
		else{
			  
			   List<JobDetails> jobsPosted = new ArrayList<JobDetails>();
				User user = (User) session.getAttribute("userSession");
				 jobsPosted = jobDetailsDAO.jobLists(user.getUserId());
			  // mv.addAttribute(attributeName, attributeValue)
				 
				 mv.addAttribute("jobspostedlist", jobsPosted);
				 view =  "employerdashboard";
			//return "employerdashboard";
			
		}
			
		}
		}
		return view;
	}
	
}
