/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.model.interviewer.*;

@Repository
@Transactional
public class InterviewerHibernateUtil {

	/**
	 * 
	 */
	public InterviewerHibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Interviewer interviewer)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.persist(interviewer);
			System.out.println("objects inserted..!!!");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}
	
	@SuppressWarnings("unchecked")
	 public List<Interviewer> fetchAll() 
	 {
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Interviewer.class);
		 return (List<Interviewer>) criteria.list();
	 }
	 
}
