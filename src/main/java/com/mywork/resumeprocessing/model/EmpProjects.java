/**
 * 
 */
package com.mywork.resumeprocessing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mk186084
 *
 */
@Entity
@Table(name = "EmpProjects")
public class EmpProjects {
	
	
	public EmpProjects() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column
	private String contact;
	
	@Column
	private String projecttitle;
	
	@Column
	private float projectduration;
	
	@Column
	private String projectdescription;
	
	@Column
	private String projectrole;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getProjecttitle() {
		return projecttitle;
	}
	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}
	public float getProjectduration() {
		return projectduration;
	}
	public void setProjectduration(float projectduration) {
		this.projectduration = projectduration;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getProjectrole() {
		return projectrole;
	}
	public void setProjectrole(String projectrole) {
		this.projectrole = projectrole;
	}


}
