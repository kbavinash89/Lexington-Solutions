package com.neu.edu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.EmployeeDAO;
import com.neu.edu.dao.JobDetailsDAO;
import com.neu.edu.pojo.JobApplication;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.User;

@Controller
public class EmployeeController {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@RequestMapping(value="/editempprofile.htm",method=RequestMethod.GET)
	public String updateProfile(HttpServletRequest request, HttpServletResponse response){
		return "editemployeedetails";
	}
		
	
	//Check for Applied Jobs
	@RequestMapping(value="/appliedjobstatus.htm",method=RequestMethod.GET)
	public ModelAndView jobStatusList(HttpServletRequest request, HttpServletResponse response){
		 ModelAndView mv = new ModelAndView();
		 List<JobDetails> jobsList = new ArrayList<JobDetails>();
		 HttpSession session = request.getSession();
		 User user = (User) session.getAttribute("userSession");
		 jobsList = jobDetailsDAO.appliedJobs(user);
			mv.addObject("employeeappliedjobs", jobsList);
			mv.setViewName("employeeappliedjobs");
			return mv;
		// return mv;
	}
	
	@RequestMapping(value="/employeedashboard.htm",method=RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response){
		return "employeedashboard";
	}
	
	
}
