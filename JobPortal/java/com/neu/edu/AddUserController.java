/**
 * 
 */
package com.neu.edu;

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

import com.neu.edu.dao.UserDAO;
import com.neu.edu.pojo.Employee;


/**
 * @author Manjunath
 *
 */
@Controller
@RequestMapping("/adduser.htm")
public class AddUserController {

	@Autowired
	//@Qualifier("adduser")
	private UserDAO userDAO;

	@Autowired
	@Qualifier("employeevalidator")
	 EmployeeValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doSubmit(@ModelAttribute("employee")Employee user,BindingResult result,Model mv){
		//String message="User Added Successfully";
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "adduser";
		}
		System.out.println("Inside Controller");
		userDAO.createUser(user.getFirstName(),user.getLastName(),user.getDateOfBirth(),user.getSex(),user.getUserName(),user.getPassword(),user.getRole(), user.getPhoneNumber(),user.getEmail());
		mv.addAttribute("success", "User Added Successfully");
			return "adduser";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("employee")Employee user, BindingResult result) { 
   
        return "adduser"; 
    } 
}
