/**
 * 
 */
package com.mywork.resumeprocessing.controller;

import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywork.resumeprocessing.model.BulkScheduledInterviews;
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
	public void scheduleInterview(@RequestParam("scheduledInterviews") String scheduleInterview)throws Exception
	{
		//boolean success = true;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		BulkScheduledInterviews scheduledInterviews = mapper.readValue(scheduleInterview, BulkScheduledInterviews.class);
		interviewSchedulerService.scheduleInterviews(scheduledInterviews.getScheduledInterviews());
	}
	
}
