/**
 * 
 */
package com.mywork.resumeprocessing.controller;

import java.io.IOException;

import com.mywork.resumeprocessing.model.Interviewer;
import com.mywork.resumeprocessing.service.EmployeeService;
import com.mywork.resumeprocessing.service.InterviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private InterviewerService interviewerService; 
	
	public InterviewerController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/addInterviewer", method = RequestMethod.POST,consumes = {"application/json"})
	public void addInterviewer(@RequestBody Interviewer interviewer)throws Exception
	{
		interviewerService.addInterviewer(interviewer);
	}
}
