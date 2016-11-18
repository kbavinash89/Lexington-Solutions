package com.neu.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.JobApplication;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.User;

@Controller
public class CompanyController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@RequestMapping(value="/addemployerdetails.htm",method=RequestMethod.POST)
	public String addEmployer(@ModelAttribute("employeers") Employer employer,BindingResult result){
		//UserDAO dao = new UserDAO();
		userDAO.createEmployer(employer.getFirstName(), employer.getLastName(), employer.getSex(), employer.getUserName(), employer.getPassword(), employer.getRole(), employer.getPhoneNumber(), employer.getEmail(), employer.getCompanyName(), 
				employer.getAddress(), employer.getLocation(), employer.getCompanyId());
		return "addemployer";
		
	}
	
	
	
	@RequestMapping(value="/employerdashboard.htm",method=RequestMethod.GET)
	public ModelAndView employeeDashBoard(HttpServletRequest request, HttpServletResponse response){
		   List<JobDetails> jobsPosted = new ArrayList<JobDetails>();
		   HttpSession session = request.getSession();
		   ModelAndView mv = new ModelAndView();
			User user = (User) session.getAttribute("userSession");
			 jobsPosted = jobDetailsDAO.jobLists(user.getUserId());
		  // mv.addAttribute(attributeName, attributeValue)
			 
			 mv.addObject("jobspostedlist", jobsPosted);
			 mv.setViewName	("employerdashboard");
			 return mv;
	}
	
	
	
	@RequestMapping(value="/addemployerdetails.htm",method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("employeers")Employer employer, BindingResult result) { 
   
        return "addemployer"; 
    }
	
	//Check for Job applied Users
	@RequestMapping(value="/checkappliedusers.htm",method=RequestMethod.GET)
	public ModelAndView redirectPage(HttpServletRequest request, HttpServletResponse response){
		List<JobDetails> jobsPosted = new ArrayList<JobDetails>();
		//JobDetailsDAO job = new JobDetailsDAO();
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		 jobsPosted = jobDetailsDAO.jobLists(user.getUserId());
		mv.addObject("jobspostedlist", jobsPosted);
		mv.setViewName("jobspostedlist");
		return mv;
		
	}
	
	//Applied job Seekers List
	@RequestMapping(value="/appliedemplist.htm",method=RequestMethod.GET)
	public ModelAndView displayEmployees(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//JobDetailsDAO job = new JobDetailsDAO();
		List<JobApplication> employeeList = new ArrayList<JobApplication>();
		String jobId = request.getParameter("action");
		employeeList = jobDetailsDAO.fetchApplicants(jobId);
		mv.addObject("employeeList", employeeList);
		mv.setViewName("appliedemployeeslist");
		return mv;
	}
	
	//Accept/Reject applicant 
	@RequestMapping(value="/applyreject.htm",method=RequestMethod.POST)
	public String acceptReject(HttpServletRequest request,HttpServletResponse response){
		String jobApplicationId = request.getParameter("jobID");
		String status = request.getParameter("status");
		jobDetailsDAO.updateStatus(Integer.parseInt(jobApplicationId),status);
		return "appliedemployeeslist";
	}
	
	//Accepted Employees List
	@RequestMapping(value="/acceptedemplist.htm",method=RequestMethod.GET)
	public ModelAndView acceptedEmpList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//JobDetailsDAO job = new JobDetailsDAO();
		List<JobApplication> employeeList = new ArrayList<JobApplication>();
		String jobId = request.getParameter("action");
		employeeList = jobDetailsDAO.acceptedApplicants(jobId);
		mv.addObject("acceptedemployeelist", employeeList);
		mv.setViewName("acceptedemployeelist");
		return mv;
	}
	
	
	//Logout of employer
	@RequestMapping(value="/signout.htm",method=RequestMethod.GET)
	public void signout(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session = request.getSession(false);
			if(session!=null){
				session.invalidate();
			}
			response.sendRedirect("http://localhost:8081/JobPortal/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/help.htm",method=RequestMethod.GET)
	public String help(HttpServletRequest request, HttpServletResponse response){
			return "help";
	}
	
	//Update Employer
	@RequestMapping(value="/updateemployer.htm",method=RequestMethod.GET)
	public String updateEmployer(HttpServletRequest request, HttpServletResponse response){
		return "editemployer";
	}
	
	//edit employer profile
	@RequestMapping(value="/editemployerprofile.htm",method=RequestMethod.GET)
	public String editEmployer(HttpServletRequest request, HttpServletResponse response,Model mv){
		mv.addAttribute("success", "Employer Updated Successfully");
		return "editemployer";
	}
	
	
	
}
