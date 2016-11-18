package com.neu.edu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.dao.DAO;
import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.Employer;
import com.neu.edu.pojo.User;

public class UserDAO extends DAO{

	public User searchUserName(String username){
		User userDetails = null;
		try{
			begin();
			Query query = getSession().createQuery("from User where userName = " +"'"+username+"'");
			//query.setString("userName", username);
			 userDetails = (User) query.uniqueResult();
			commit();
			
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return userDetails;
	}
	
	public Employee createUser(String firstName, String lastName, String dob,String sex, String userName, String password,String role,int phoneNumber, String email){
		Employee user = new Employee();
		try{
			begin();		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(dob);
		user.setSex(sex);
		user.setRole(role);
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		getSession().save(user);
		commit();
		
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return user;
	}
	
	public Employer createEmployer(String firstName, String lastName, String sex, String userName, String password,String role,int phoneNumber, String email,String cmpanyName,String companyAddr, String location, String companyId,String companyName){
		Employer user = new Employer();
		try{
			begin();		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		//user.setDateOfBirth(dob);
		user.setSex(sex);
		user.setRole(role);
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setCompanyId(companyId);
		user.setLocation(location);
		user.setAddress(companyAddr);
		user.setCompanyName(companyName);
		
		getSession().save(user);
		commit();
		
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return user;
	}
	
	
}
