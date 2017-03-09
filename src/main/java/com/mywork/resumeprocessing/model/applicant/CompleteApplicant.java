/**
 * 
 */
package com.mywork.resumeprocessing.model.applicant;

import java.util.List;

/**
 * @author ManiKanta Kandagatla
 *
 */
public class CompleteApplicant {

	public CompleteApplicant() {
		// TODO Auto-generated constructor stub
	}

	ApplicantProfile emp;
	List<ApplicantProjects> projects;
	public ApplicantProfile getEmp() {
		return emp;
	}
	public void setEmp(ApplicantProfile emp) {
		this.emp = emp;
	}
	public List<ApplicantProjects> getProjects() {
		return projects;
	}
	public void setProjects(List<ApplicantProjects> projects) {
		this.projects = projects;
	}
}
