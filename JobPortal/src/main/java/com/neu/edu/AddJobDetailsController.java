package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.JobDetailsDAO;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/addjob.htm")
public class AddJobDetailsController {

	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit(@ModelAttribute("job") JobDetails job,BindingResult result, HttpServletRequest request){
		System.out.println("Inside addjob controller");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		jobDetailsDAO.createJob(user,job.getJobId(), job.getDescription(), job.getRequirements(), job.getCompany(), job.getLocation(), job.getPay(), job.getEmploymentType(), job.getJobTitle(), job.getPostedDate(), job.getExpiryDate());
		return "addjobs";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("job")JobDetails job, BindingResult result) { 
   
        return "addjobs"; 
    }
}
