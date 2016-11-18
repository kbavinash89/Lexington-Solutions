package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.EmployeeDAO;
import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/updateemployee.htm")
public class EditEmployee {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
		@RequestMapping(method=RequestMethod.POST)
	public String updateEmployee(HttpServletRequest request, HttpServletResponse response){
		//EmployeeDAO emp = new EmployeeDAO();
		//employeeDAO.updateEmployee(user);
		return "editemployeedetails";
	}
	
}
