package com.neu.edu.dao;

import org.hibernate.HibernateException;

import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.User;

public class EmployeeDAO extends DAO{
	
	public void updateEmployee(Employee user){
		Employee employee = new Employee();
		try{
			int id = user.getUserId();
			begin();
			employee = (Employee) getSession().get(Employee.class, id);
			employee.setFirstName(user.getFirstName());
			employee.setLastName(user.getLastName());
			employee.setRole(user.getRole());
			employee.setDate(user.getDate());
			employee.setSex(user.getSex());
		getSession().update(employee);
		commit();
		
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		
	}
	

}
