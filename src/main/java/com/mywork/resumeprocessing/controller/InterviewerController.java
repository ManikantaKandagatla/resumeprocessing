/**
 * 
 */
package com.mywork.resumeprocessing.controller;

import java.io.IOException;
import java.util.List;

import com.mywork.resumeprocessing.model.interviewer.Interviewer;
import com.mywork.resumeprocessing.service.InterviewerService;
import org.apache.log4j.Logger; 
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ManiKanta Kandagatla
 *
 */

@RestController
@Configuration
@ComponentScan("com.mywork.resumeprocessing.service")
public class InterviewerController {

	/**
	 * 
	 */
	private static final Logger log = Logger.getLogger(InterviewerController.class);
	@Autowired
	private InterviewerService interviewerService; 
	
	public InterviewerController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/addInterviewer", method = RequestMethod.POST)
	public void addInterviewer(@RequestParam("interviewer") String strinterviewer)throws Exception
	{
		//boolean success = true;
		log.info("Adding new Interviewer");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Interviewer interviewer = mapper.readValue(strinterviewer, Interviewer.class);
		interviewerService.addInterviewer(interviewer);
		
	}
	
	@RequestMapping(value= "/retrieveAllInterviewers", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	public @ResponseBody List<Interviewer> getAllEmps()
	{
		log.info("Retrieving all Interviewers");
		List<Interviewer> allInterviewers = interviewerService.getAllinterviewer();
		log.info("Retrieved " +allInterviewers.size()+" employees");
		return allInterviewers;
	}
}
