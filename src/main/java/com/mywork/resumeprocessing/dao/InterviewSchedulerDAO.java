package com.mywork.resumeprocessing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.model.scheduleinterview.CallApplicantToInterview;
import com.mywork.resumeprocessing.model.scheduleinterview.ScheduledInterview;
import com.mywork.resumeprocessing.util.InterviewSchedulerUtil;

@Repository
@Transactional
public class InterviewSchedulerDAO {
	 
	@Autowired
	private InterviewSchedulerUtil interviewerSchedulerUtil;
	
	public void scheduleInterviews(List<ScheduledInterview> scheduledInterviews)
	{
		interviewerSchedulerUtil.scheduleInterviews(scheduledInterviews);
	}

	public void callApplicantsToInterviews(List<CallApplicantToInterview> callApplicantstoInterviews) {
		// TODO Auto-generated method stub
		interviewerSchedulerUtil.callApplicantsToInterviews(callApplicantstoInterviews);
	}

}
