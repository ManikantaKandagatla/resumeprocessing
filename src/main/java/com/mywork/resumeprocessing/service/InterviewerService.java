/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.service;

import javax.transaction.Transactional;

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
	@Autowired
	private InterviewerDAO interviewerDAO;
	
	public InterviewerService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addInterviewer(Interviewer interviewer)
	{
		interviewerDAO.addInterviewer(interviewer);
	}
}
