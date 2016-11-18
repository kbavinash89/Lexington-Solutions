package com.neu.edu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jobpostings")
public class JobDetails {

	@Id
	@GeneratedValue
	@Column(name="JobID")
	private int jobId;
	private String description;
	private String requirements;
	private String company;
	private String postedDate;
	private String expiryDate;
	private String jobTitle;
	private String pay;
	private String location;
	private String employmentType;
	
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;
	

	@OneToMany(mappedBy="jobDetails")
	@JoinColumn(name="jobappiedID")
	private List<JobApplication> jobAppiedList = new ArrayList<JobApplication>();
	
	
	

	public List<JobApplication> getJobAppiedList() {
		return jobAppiedList;
	}
	public void setJobAppiedList(List<JobApplication> jobAppiedList) {
		this.jobAppiedList = jobAppiedList;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
}
