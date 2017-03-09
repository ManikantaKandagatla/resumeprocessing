package com.mywork.resumeprocessing.model.applicant;
/**
 * @author ManiKanta Kandagatla
 *
 */

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EmpResume")
public class ApplicantResume implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2287588917743318363L;

	@Id
	@OneToOne
    @JoinColumn(name="contact")
	private ApplicantProfile empprofile;
	
	@Column
	@Lob @Basic(fetch = FetchType.LAZY)
	private byte[] empresume;

	public ApplicantProfile getEmpprofile() {
		return empprofile;
	}

	public void setEmpprofile(ApplicantProfile empprofile) {
		this.empprofile = empprofile;
	}

	public byte[] getEmpresume() {
		return empresume;
	}

	public void setEmpresume(byte[] empresume) {
		this.empresume = empresume;
	}

	public ApplicantResume()
	{

	}
}
