package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.JobDetailsDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Employer;

@Controller
@RequestMapping("/addemployerdetails.htm")
public class EmployerController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	@Qualifier("employervalidator")
	 EmployerValidator employervalidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employervalidator);
	}
	


	@RequestMapping(method=RequestMethod.POST)
	public String addEmployer(@ModelAttribute("employeers") Employer employer,BindingResult result,Model mv){
		//UserDAO dao = new UserDAO();
		employervalidator.validate(employer, result);
		if (result.hasErrors()) {
			return "addemployer";
		}
		userDAO.createEmployer(employer.getFirstName(), employer.getLastName(), employer.getSex(), employer.getUserName(), employer.getPassword(), employer.getRole(), employer.getPhoneNumber(), employer.getEmail(), employer.getCompanyName(), 
				employer.getAddress(), employer.getLocation(), employer.getCompanyId(),employer.getCompanyName());
		mv.addAttribute("success", "Employer Added Successfully");
		return "addemployer";
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("employeers")Employer employer, BindingResult result) { 
   
        return "addemployer"; 
    }
}
