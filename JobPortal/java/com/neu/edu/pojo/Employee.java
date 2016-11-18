package com.neu.edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee extends User{

	@ManyToMany(mappedBy="userDetails")
	@JoinColumn(name="jobApplicationID")
	private List<JobApplication> jobsApplied = new ArrayList<JobApplication>();
	
	

	public List<JobApplication> getJobsApplied() {
		return jobsApplied;
	}
	public void setJobsApplied(List<JobApplication> jobsApplied) {
		this.jobsApplied = jobsApplied;
	}
	private String dateOfBirth;



	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

	
	
}
