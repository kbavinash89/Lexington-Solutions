package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Autowired
	@Qualifier("jobdetailvalidator")
	 AddJobDetailsValidator jobdetailvalidator;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit(@ModelAttribute("job") JobDetails job,BindingResult result, HttpServletRequest request,Model mv){
		System.out.println("Inside addjob controller");
		jobdetailvalidator.validate(job, result);
		if (result.hasErrors()) {
			return "addjobs";
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userSession");
		jobDetailsDAO.createJob(user,job.getJobId(), job.getDescription(), job.getRequirements(), job.getCompany(), job.getLocation(), job.getPay(), job.getEmploymentType(), job.getJobTitle(), job.getPostedDate(), job.getExpiryDate());
		mv.addAttribute("success", "Job Added Successfully");
		return "addjobs";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("job")JobDetails job, BindingResult result) { 
   
        return "addjobs"; 
    }
}
