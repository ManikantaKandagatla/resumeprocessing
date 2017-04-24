/**
 * 
 */
package com.mywork.resumeprocessing.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywork.resumeprocessing.model.scheduleinterview.BulkCallApplicantToInterview;
import com.mywork.resumeprocessing.model.scheduleinterview.BulkScheduledInterviews;
import com.mywork.resumeprocessing.service.InterviewSchedulerService;

/**
 * @author ManiKanta Kandagatla
 *
 */
@RestController
public class InterviewSchedulerController {

	private static final Logger log = LoggerFactory.getLogger(InterviewerController.class);
	
	@Autowired
	private InterviewSchedulerService interviewSchedulerService;
	
	@RequestMapping(value = "/scheduleInterviews", method = RequestMethod.POST)
	public void scheduleInterview(@RequestParam("scheduledInterviews") String scheduleInterviews)
	{
		//boolean success = true;
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			BulkScheduledInterviews scheduledInterviews = mapper.readValue(scheduleInterviews, BulkScheduledInterviews.class);
			interviewSchedulerService.scheduleInterviews(scheduledInterviews.getScheduledInterviews());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/callApplicantToInterview",method = RequestMethod.POST)
	public void callApplicantToInterview(@RequestParam("callApplicantsToInterviews") String callApplicantsToInterview)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			BulkCallApplicantToInterview callApplicantsToInterviews = mapper.readValue(callApplicantsToInterview, BulkCallApplicantToInterview.class);
			interviewSchedulerService.callApplicantsToInterviews(callApplicantsToInterviews.getCallApplicantstoInterviews());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	
}
