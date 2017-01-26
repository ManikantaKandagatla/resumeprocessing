/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywork.resumeprocessing.dao.InterviewerDAO;
import com.mywork.resumeprocessing.model.Interviewer;;

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
	private static final Logger log = LoggerFactory.getLogger(InterviewerService.class);
	@Autowired
	private InterviewerDAO interviewerDAO;
	
	public InterviewerService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addInterviewer(Interviewer interviewer)
	{
		log.info("Creating Employee..!!");
		interviewerDAO.addInterviewer(interviewer);
	}
	
	public List<Interviewer> getAllinterviewer()
	{
		log.info("Retrieving Employees..!!");
		return interviewerDAO.getAllinterviewer();
	}
}
