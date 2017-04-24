package com.mywork.resumeprocessing.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywork.resumeprocessing.dao.InterviewSchedulerDAO;
import com.mywork.resumeprocessing.model.scheduleinterview.CallApplicantToInterview;
import com.mywork.resumeprocessing.model.scheduleinterview.ScheduledInterview;

@Service
public class InterviewSchedulerService {

	@Autowired
	private InterviewSchedulerDAO interviewSchedulerDAO;
	
	public void scheduleInterviews(List<ScheduledInterview> scheduledInterviews)
	{
		interviewSchedulerDAO.scheduleInterviews(scheduledInterviews);
	}

	public void callApplicantsToInterviews(List<CallApplicantToInterview> callApplicantstoInterviews) {
		// TODO Auto-generated method stub
		interviewSchedulerDAO.callApplicantsToInterviews(callApplicantstoInterviews);
	}
}
