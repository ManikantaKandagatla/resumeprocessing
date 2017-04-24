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

import com.mywork.resumeprocessing.model.scheduleinterview.CallApplicantToInterview;
import com.mywork.resumeprocessing.model.scheduleinterview.ScheduledInterview;
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
	
	
	public void callApplicantsToInterviews(List<CallApplicantToInterview> callApplicantsToInterviews)
	{
		try
		{
			Session session = sessionFactory.getCurrentSession();
			for(CallApplicantToInterview callApplicantToInterview: callApplicantsToInterviews)
			{
				session.persist(callApplicantToInterview);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
