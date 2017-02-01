/**
 * 
 */
package com.mywork.resumeprocessing.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author ManiKanta Kandagatla
 *
 */
@Entity
@Table(name = "InterviewScheduler")
public class InterviewScheduler {
	
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
	private EmpProfile empprofile;
	
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

	public EmpProfile getEmpprofile() {
		return empprofile;
	}

	public void setEmpprofile(EmpProfile empprofile) {
		this.empprofile = empprofile;
	}

	public Date getDateofinterview() {
		return dateofinterview;
	}

	public void setDateofinterview(Date dateofinterview) {
		this.dateofinterview = dateofinterview;
	}
	
}
