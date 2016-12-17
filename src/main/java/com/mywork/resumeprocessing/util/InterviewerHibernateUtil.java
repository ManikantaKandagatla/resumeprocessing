/**
 * 
 */
package com.mywork.resumeprocessing.util;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mywork.resumeprocessing.model.Interviewer;;

/**
 * @author ManiKanta Kandagatla
 *
 */
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
			Session session = sessionFactory.openSession();
			long id = (Long) session.save(interviewer);
			System.out.println(""+id+" objects inserted..!!!");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}

}
