package com.neu.edu.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Appliedjobs")
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jobApplicationId")
	private int jobApplicationID;
	private int jobId;
	private float totalWorkExp;
	private String previousCompnay;
	private String status;
	//private MultipartFile resume;
	
	@ManyToMany
	private List<User> userDetails = new ArrayList<User>();
		

	@ManyToOne
	@JoinColumn(name="jobDetailsID")
	private JobDetails jobDetails;

	

	public JobDetails getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
	public List<User> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(List<User> userDetails) {
		this.userDetails = userDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getJobApplicationID() {
		return jobApplicationID;
	}
	public void setJobApplicationID(int jobApplicationID) {
		this.jobApplicationID = jobApplicationID;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public float getTotalWorkExp() {
		return totalWorkExp;
	}
	public void setTotalWorkExp(float totalWorkExp) {
		this.totalWorkExp = totalWorkExp;
	}
	public String getPreviousCompnay() {
		return previousCompnay;
	}
	public void setPreviousCompnay(String previousCompnay) {
		this.previousCompnay = previousCompnay;
	}

	
}
