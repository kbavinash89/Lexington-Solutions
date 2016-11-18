package com.neu.edu;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.JobDetails;

public class AddJobDetailsValidator implements Validator{

    public boolean supports(Class aClass)
    {
        return aClass.equals(JobDetails.class);
    }

    public void validate(Object obj, Errors errors)
    {
        JobDetails user = (JobDetails) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requirements", "error.invalid.requirements", "Requirements Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "error.invalid.company", "Company Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postedDate", "error.invalid.postedDate", "Posted Date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expiryDate", "error.invalid.expiryDate", "Expiry Date Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.jobTitle", "Job Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pay", "error.invalid.pay", "Pay Required");
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.location", "location Required");
    }
}
