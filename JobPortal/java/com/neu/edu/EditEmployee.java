package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.neu.edu.dao.EmployeeDAO;
import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/updateemployee.htm")
public class EditEmployee {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	

	
		@RequestMapping(method=RequestMethod.POST)
	public String updateEmployee(HttpServletRequest request, HttpServletResponse response,Model mv){
		//EmployeeDAO emp = new EmployeeDAO();
		//employeeDAO.updateEmployee(user);
			Employee emp = new Employee();
			HttpSession session = request.getSession();
			emp = (Employee) session.getAttribute("userSession");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String phonenumber = request.getParameter("phone");
			int phone = Integer.parseInt(phonenumber);
			String email = request.getParameter("email");
			employeeDAO.updateEmployee(emp.getUserId(),username,password,phone,email);
			mv.addAttribute("success", "Updated Successfully");
			
		return "editemployeedetails";
	}
	

}
