package com.neu.edu.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class DAO {

	public static final ThreadLocal sessionThread = new ThreadLocal();
	private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	public DAO(){		
	}
	
	public static Session getSession(){
		
		Session session = (Session) DAO.sessionThread.get();
		if(session == null){
			session = sessionFactory.openSession();
			DAO.sessionThread.set(session);
		}
		
		return session;
	}
	
	public void begin(){
		getSession().beginTransaction();
	}
	
	public void commit(){
		getSession().getTransaction().commit();
	}
	
	public void rollback(){
		try{
		getSession().getTransaction().rollback();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
