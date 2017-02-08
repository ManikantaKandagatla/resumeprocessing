package com.mywork.resumeprocessing.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywork.resumeprocessing.dao.InterviewSchedulerDAO;
import com.mywork.resumeprocessing.model.ScheduledInterview;

@Service
public class InterviewSchedulerService {

	@Autowired
	private InterviewSchedulerDAO interviewSchedulerDAO;
	
	public void scheduleInterviews(List<ScheduledInterview> scheduledInterviews)
	{
		interviewSchedulerDAO.scheduleInterviews(scheduledInterviews);
	}
}
