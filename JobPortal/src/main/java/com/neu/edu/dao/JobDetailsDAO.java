package com.neu.edu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.edu.pojo.Employee;
import com.neu.edu.pojo.JobApplication;
import com.neu.edu.pojo.JobDetails;
import com.neu.edu.pojo.User;

public class JobDetailsDAO extends DAO{
private List<JobDetails> job;
private List<JobApplication> appliedJobList;
private JobDetails jobdescription;
	public List<JobDetails> searchJob(String jobDetail){
	 
		try{
			begin();
			Query query = getSession().createQuery("from JobDetails where company like "+"'%"+
			jobDetail+"%'"+" or requirements like"+"'%"+jobDetail+"%'");
			job =  query.list();
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return job;
	}
	
	//get description	
			public JobDetails getJobDescription(String jobId){				
				try{
					begin();
					Query query = getSession().createQuery("from JobDetails where jobId = "+"'"+jobId+"'");
					jobdescription =  (JobDetails) query.uniqueResult();
					commit();
				}catch(HibernateException e){
					rollback();
					e.printStackTrace();
				}
				return jobdescription;
			}
	
	public JobDetails createJob(User user,int jobId, String description, String requirements, String company, String location, String pay, String employmentType, String jobTitle, String postedDate,String expiryDate){
		JobDetails job = new JobDetails();
		try{
			begin();	
			job.setUser(user);
		job.setJobTitle(jobTitle);
		job.setCompany(company);
		job.setDescription(description);
		job.setEmploymentType(employmentType);
		job.setExpiryDate(expiryDate);
		job.setJobId(jobId);
		job.setLocation(location);
		job.setPay(pay);
		job.setPostedDate(postedDate);
		job.setRequirements(requirements);
		getSession().save(job);
		commit();
		
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return job;
	}
	
/*	public void addJob(JobApplication jobapply){
		try{
			getSession().save(jobapply);
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
	}*/
	
	public void applyJob(int jobID,String companyName, float workExp, User user){
		JobApplication appliedjob = new JobApplication();
		
		try{
			begin();
			appliedjob.setJobId(jobID);
			appliedjob.setTotalWorkExp(workExp);
			appliedjob.setPreviousCompnay(companyName);
			appliedjob.getUserDetails().add(user);
			//appliedjob.setJobDetails(jobDetails);
		 getSession().save(appliedjob);
		 commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
	}
	
	
	//Display jobs posted  by employer
	public List<JobDetails> jobLists(int employerId){
		
		try{
			begin();
			Query query = getSession().createQuery("from JobDetails where userId = "+employerId);
			//query.setString("userID", employerId);
			job = query.list();
			commit();
			
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return job;
	}
	
	//Fetch User Details applied for applied jobs
	public List<JobApplication> fetchApplicants(String jobId){
		int id = Integer.parseInt(jobId);
		try{
			begin();
			//Query query = getSession().createQuery("from JobApplication job inner join job.userDetails where job.jobId ="+"'"+jobId+"'");
			//Query query = getSession().createQuery("from JobApplication where status<>: and  jobId = :jobid");
			Criteria cr = getSession().createCriteria(JobApplication.class,"jobApplication");
			cr.setFetchMode("jobApplication.userDetails", FetchMode.JOIN);
			cr.createAlias("jobApplication.userDetails", "users");
			cr.add(Restrictions.eq("jobApplication.jobId", id));
			cr.add(Restrictions.isNull("jobApplication.status"));
			//query.setParameter("reject", "accept");
			//Criteria cr = getClass().createCriteria()
			//query.setParameter("null", "null");
			//query.setString("jobid", jobId);
			appliedJobList = cr.list();
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return appliedJobList;
	}
	
	
	
	//Check for applied jobs
	public List<JobDetails> appliedJobs(User user){
		
		try{
			begin();
			//Query query = getSession().createQuery("from JobDetails where user = '"+user.getUserId()+"'" );
			//Query query = getSession().createQuery("select job.jobId , job.description, job.company, "
			//		+ "job.jobTitle from JobDetails job inner join job.jobAppiedList");
			Query query = getSession().createSQLQuery("select  distinct job.JobID,job.company,job.description, "
					+ "job.jobTitle,job.location,  applied.status "
					+ " from jobpostings job inner join   "
					+ " appliedjobs_userdetails  user  on  "
					+ " job.jobId = user.jobsApplied_jobApplicationId  "
					+ " inner join Appliedjobs applied on "
					+ "user.jobsApplied_jobApplicationId = applied.jobApplicationId  "
					+ " where user.userDetails_UserId =:userID");
			query.setInteger("userID", user.getUserId());
			job =  (List<JobDetails>)query.list();
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return job;
	}
	
	
	public void updateStatus(int jobApplicationId, String status){
		String hql=null;
		try{
			begin();
			//Query query = getSession().createQuery("from JobDetails where user = '"+user.getUserId()+"'" );
			//Query query = getSession().createQuery("select job.jobId , job.description, job.company, "
			//		+ "job.jobTitle from JobDetails job inner join job.jobAppiedList");

			 hql = "update JobApplication set status = :result where"
					+ " jobApplicationID = :jobApplicationID";
			
				
			Query query = getSession().createQuery(hql);
			query.setString("result", status);
			query.setParameter("jobApplicationID", jobApplicationId);
			int result = query.executeUpdate();
			//job =  (List<JobDetails>)query.list();
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
	}
	
	
	//Accepted Employees List
	public List<JobApplication> acceptedApplicants(String jobId){
		int id = Integer.parseInt(jobId);
		try{
			begin();
			//Query query = getSession().createQuery("from JobApplication job inner join job.userDetails where job.jobId ="+"'"+jobId+"'");
			//Query query = getSession().createQuery("from JobApplication where status<>: and  jobId = :jobid");
			Criteria cr = getSession().createCriteria(JobApplication.class,"jobApplication");
			cr.setFetchMode("jobApplication.userDetails", FetchMode.JOIN);
			cr.createAlias("jobApplication.userDetails", "users");
			cr.add(Restrictions.eq("jobApplication.jobId", id));
			cr.add(Restrictions.eq("jobApplication.status","accept"));
			//query.setParameter("reject", "accept");
			//Criteria cr = getClass().createCriteria()
			//query.setParameter("null", "null");
			//query.setString("jobid", jobId);
			appliedJobList = cr.list();
			commit();
		}catch(HibernateException e){
			rollback();
			e.printStackTrace();
		}
		return appliedJobList;
	}
	
}
