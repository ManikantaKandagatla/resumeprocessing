/**
 * 
 */
package com.mywork.resumeprocessing.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mywork.resumeprocessing.model.ScheduledInterview;
/**
 * @author ManiKanta Kandagatla
 *
 */
@Repository
@Transactional
public class InterviewSchedulerUtil {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void scheduleInterviews(List<ScheduledInterview> scheduledInterviews)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			for(ScheduledInterview scheduledInterview: scheduledInterviews)
			{
				session.persist(scheduledInterview);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
