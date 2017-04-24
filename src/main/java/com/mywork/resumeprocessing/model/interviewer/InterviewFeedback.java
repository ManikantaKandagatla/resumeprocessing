package com.mywork.resumeprocessing.model.interviewer;
/**
 * @author ManiKanta Kandagatla
 *
 */

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mywork.resumeprocessing.model.scheduleinterview.ScheduledInterview;


@Entity
@Table(name = "InterviewFeedback")
public class InterviewFeedback implements Serializable{
	
	@Id
	@OneToOne
    @JoinColumn(name="meetingid")
	private ScheduledInterview scheduledInterview;
	
	private String feedback;
	
	private String WhatwereAsked;

	public ScheduledInterview getScheduledInterview() {
		return scheduledInterview;
	}

	public void setScheduledInterview(ScheduledInterview scheduledInterview) {
		this.scheduledInterview = scheduledInterview;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getWhatwereAsked() {
		return WhatwereAsked;
	}

	public void setWhatwereAsked(String whatwereAsked) {
		WhatwereAsked = whatwereAsked;
	}
	
	
}
