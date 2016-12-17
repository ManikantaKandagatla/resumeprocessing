/**
 * 
 */
package com.mywork.resumeprocessing.model;

import java.util.List;

/**
 * @author mk186084
 *
 */
public class CompleteEmployee {

	public CompleteEmployee() {
		// TODO Auto-generated constructor stub
	}

	EmpProfile emp;
	List<EmpProjects> projects;
	public EmpProfile getEmp() {
		return emp;
	}
	public void setEmp(EmpProfile emp) {
		this.emp = emp;
	}
	public List<EmpProjects> getProjects() {
		return projects;
	}
	public void setProjects(List<EmpProjects> projects) {
		this.projects = projects;
	}
}
