package com.neu.edu;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Employee;

public class EmployeeValidator implements Validator{

    public boolean supports(Class aClass)
    {
        return aClass.equals(Employee.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Employee user = (Employee) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "error.invalid.user", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.user", "Phone Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "error.invalid.dateOfBirth", "DateOfBirth Required");
    }
}
