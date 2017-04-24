/**
 * 
 */
package com.mywork.resumeprocessing.model.interviewer;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author ManiKanta Kandagatla
 *
 */
@Entity
@Table(name = "interviewer")
public class Interviewer {

	/**
	 * 
	 */
	@Column
	private String firstname;
	
	
	@Column
	private String lastname;
	
	@Id
	@Column
	private String quicklookid;
	
	@Column
	private String role;
	
	@Column
	private String expertese;
	
	@Column 
	private String mail;
	
	@Column
	private String contact;
	
	
	public Interviewer() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getQuicklookid() {
		return quicklookid;
	}

	public void setQuicklookid(String quicklookid) {
		this.quicklookid = quicklookid;
	}

	public String getExpertese() {
		return expertese;
	}

	public void setExpertese(String expertese) {
		this.expertese = expertese;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
