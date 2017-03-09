/**
 * 
 */
package com.mywork.resumeprocessing.model.scheduleinterview;

/**
 * @author ManiKanta Kandagatla
 *
 */

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



@Entity
@Table(name = "CallApplicantToInterview")
public class CallApplicantToInterview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	long invitationId;
	
	@OneToOne
    @JoinColumn(name="contact")
	private ApplicantProfile empprofile;
	
	@Column
	private Date dateofreporting;
	
	public long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(long invitationId) {
		this.invitationId = invitationId;
	}

	public ApplicantProfile getEmpprofile() {
		return empprofile;
	}

	public void setEmpprofile(ApplicantProfile empprofile) {
		this.empprofile = empprofile;
	}

	public Date getDateofreporting() {
		return dateofreporting;
	}

	public void setDateofreporting(Date dateofreporting) {
		this.dateofreporting = dateofreporting;
	}
	
}
