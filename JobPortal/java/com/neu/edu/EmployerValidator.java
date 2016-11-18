package com.neu.edu;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Employer;

public class EmployerValidator implements Validator{
	   public boolean supports(Class aClass)
	    {
	        return aClass.equals(Employer.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	        Employer user = (Employer) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "error.invalid.user", "Gender Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user", "Email Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.user", "Phone Number Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "Location Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.companyName", "Company Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyId", "error.invalid.companyId", "Company ID Required");
	       
	        
	    }

}
