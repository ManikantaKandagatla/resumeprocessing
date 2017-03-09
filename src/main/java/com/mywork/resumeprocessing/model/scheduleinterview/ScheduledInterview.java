/**
 * 
 */
package com.mywork.resumeprocessing.model.scheduleinterview;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mywork.resumeprocessing.model.applicant.ApplicantProfile;
import com.mywork.resumeprocessing.model.interviewer.Interviewer;

/**
 * @author ManiKanta Kandagatla
 *
 */
@Entity
@Table(name = "ScheduledInterview")
public class ScheduledInterview {
	
	@Id
	@Column
	private String meetingid;
	
	@Column 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roundno;
	
	@OneToOne
    @JoinColumn(name="quicklookid")
	private Interviewer interviewer;
	

	@OneToOne
    @JoinColumn(name="contact")
	private ApplicantProfile empprofile;
	
	@Column
	private Date dateofinterview;
	
	public String getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(String meetingid) {
		this.meetingid = meetingid;
	}

	public String getRoundno() {
		return roundno;
	}

	public void setRoundno(String roundno) {
		this.roundno = roundno;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public ApplicantProfile getEmpprofile() {
		return empprofile;
	}

	public void setEmpprofile(ApplicantProfile empprofile) {
		this.empprofile = empprofile;
	}

	public Date getDateofinterview() {
		return dateofinterview;
	}

	public void setDateofinterview(Date dateofinterview) {
		this.dateofinterview = dateofinterview;
	}
	
}
