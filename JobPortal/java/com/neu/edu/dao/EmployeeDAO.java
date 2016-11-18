package com.neu.edu.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.User;

public class EmployeeDAO extends DAO{
	
	public void updateEmployee(int userId,String username,String password,int phone,String email){
		Employee employee = new Employee();
		try{
			//int id = user.getUserId();
			begin();
			/*employee = (Employee) getSession().get(Employee.class, id);
			employee.setFirstName(user.getFirstName());
			employee.setLastName(user.getLastName());
			employee.setRole(user.getRole());
			employee.setDateOfBirth(user.getDateOfBirth());
			employee.setSex(user.getSex());*/
		Query query = getSession().createQuery("update User set userName=:username, password=:password,"
				+ " phoneNumber=:phone, email=:email where userId=:userid");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("phone",phone);
		query.setParameter("email", email);
		query.setParameter("userid", userId);
		int result = query.executeUpdate();
		commit();
		
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		
	}
	

}
