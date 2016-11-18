/**
 * 
 */
package com.neu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

	@RequestMapping(method = RequestMethod.POST)
	public String doSubmit(@ModelAttribute("employee")Employee user,BindingResult result){
		System.out.println("Inside Controller");
		userDAO.createUser(user.getFirstName(),user.getLastName(),user.getDate(),user.getSex(),user.getUserName(),user.getPassword(),user.getRole(), user.getPhoneNumber(),user.getEmail());
			return "adduser";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("employee")Employee user, BindingResult result) { 
   
        return "adduser"; 
    } 
}
