/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywork.resumeprocessing.dao.InterviewerDAO;
import com.mywork.resumeprocessing.model.interviewer.*;

/**
 * @author ManiKanta Kandagatla
 *
 */
@Service
@Transactional
public class InterviewerService {

	/**
	 * 
	 */
	private static final Logger log = Logger.getLogger(InterviewerService.class);
	@Autowired
	private InterviewerDAO interviewerDAO;
	
	public InterviewerService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addInterviewer(Interviewer interviewer)
	{
		log.info("Creating Interviewer..!!");
		interviewerDAO.addInterviewer(interviewer);
	}
	
	public List<Interviewer> getAllinterviewer()
	{
		log.info("Retrieving Interviewers..!!");
		return interviewerDAO.getAllinterviewer();
	}
}
