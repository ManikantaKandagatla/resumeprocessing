/**
 * 
 */
package com.teradata.resumeprocessing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teradata.resumeprocessing.model.Interviewer;
import com.teradata.resumeprocessing.util.InterviewerHibernateUtil;

/**
 * @author ManiKanta Kandagatla
 *
 */

@Repository
@Transactional
public class InterviewerDAO {

	@Autowired
	 private InterviewerHibernateUtil interviewerHibernateUtil;
	/**
	 * 
	 */
	public InterviewerDAO() {
		// TODO Auto-generated constructor stub
	}

	public void addInterviewer(Interviewer interviewer) {
		interviewerHibernateUtil.save(interviewer);
	}
}
