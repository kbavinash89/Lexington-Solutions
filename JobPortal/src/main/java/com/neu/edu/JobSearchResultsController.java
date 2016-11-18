package com.neu.edu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.edu.dao.JobDetailsDAO;
import com.neu.edu.pojo.JobApplication;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.User;

@Controller

public class JobSearchResultsController {
	
	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@RequestMapping("/searchresults.htm")
	public ModelAndView doSubmit(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		List<JobDetails> job = new ArrayList<JobDetails>();
		String jobDetails = request.getParameter("jobsearch");
	//	JobDetailsDAO dao = new JobDetailsDAO();
		job = jobDetailsDAO.searchJob(jobDetails);
		session.setAttribute("job", job);
		mv.addObject("job", job);
		mv.setViewName("jobdetails");
		return mv;
	}
	
	@RequestMapping(value="/jobdescription.htm", method = RequestMethod.GET)
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String jobId = request.getParameter("action");
		//JobDetailsDAO dao = new JobDetailsDAO();
	    JobDetails job = jobDetailsDAO.getJobDescription(jobId);
		mv.addObject("jobdescriptions", job);
		mv.setViewName("jobdescriptions");
		return mv;
	}
	
	
	@RequestMapping(value="/applyjob.htm", method = RequestMethod.GET)
	public ModelAndView doSubmitRequest(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String jobId = request.getParameter("jobId");
		mv.addObject("applyjobdetails",jobId);
		mv.setViewName("applyjobdetails");
		return mv;
	}
	
	
	//Apply job Mapping
/*	@RequestMapping(value="/applynewjob.htm",method=RequestMethod.POST)
	public String submitApplication(@ModelAttribute("jobapply")JobApplication jobapply, BindingResult result){
		System.out.println("Inside apply new job controller");
		JobDetailsDAO job = new JobDetailsDAO();
		try{
			job.addJob(jobapply);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "applyjobdetails";
	}
	@RequestMapping(value="/applynewjob.htm",method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("jobapply")JobApplication jobapply, BindingResult result) { 
   
        return "applyjobdetails"; 
    }	*/
	
	@RequestMapping(value="/applynewjob.htm",method=RequestMethod.POST)
	public String applyJob(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("Inside apply new job controller");
		JobDetailsDAO job = new JobDetailsDAO();
		try{
			HttpSession session = request.getSession();
			float workExp = Float.parseFloat(request.getParameter("workexperience"));
			String companyName = request.getParameter("companyname");
			User user = (User) session.getAttribute("userSession");
			String jobId = request.getParameter("jobid");
			job.applyJob(Integer.parseInt(jobId), companyName, workExp, user);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "applyjobdetails";
	}
	
}
