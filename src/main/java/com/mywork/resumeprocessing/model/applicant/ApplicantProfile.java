package com.mywork.resumeprocessing.model.applicant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "EmpProfile")
public class ApplicantProfile implements Serializable {

	
	private static final long serialVersionUID = -7988799579036225137L;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	
	@Id
	@Column
	private String contact;
	
	@Column
	private String email;
	
	@Column
	private Float currentexperience;
	
	@Column
	private Float totalexperience;
	
	@Column
	private String skillset;
	
	@Column
	private String designation;
	
	@Column
	private String location;
	
	@Column
	private String qualification;
	


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


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Float getCurrentexperience() {
		return currentexperience;
	}
	
	public void setCurrentexperience(Float currentexperience) {
		this.currentexperience = currentexperience;
	}


	public Float getTotalexperience() {
		return totalexperience;
	}

	public void setTotalexperience(Float totalexperience) {
		this.totalexperience = totalexperience;
	}


	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ApplicantProfile() {
	}
	
	/*
	@Override
	public String toString() {
		return "Employee{" +
		"id=" + id +
		", firstname='" + firstname + '\'' +
		", lastname=" + lastname +
		", contact=" + contact +
		'}';
	}*/
} 