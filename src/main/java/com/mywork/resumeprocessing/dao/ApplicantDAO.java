package com.mywork.resumeprocessing.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.model.applicant.CompleteApplicant;
import com.mywork.resumeprocessing.model.applicant.ApplicantProfile;
import com.mywork.resumeprocessing.model.applicant.ApplicantProjects;
import com.mywork.resumeprocessing.model.applicant.ApplicantResume;
import com.mywork.resumeprocessing.util.ApplicantHibernateUtil;


@Repository
@Transactional
public class ApplicantDAO  {
	
	 @Autowired
	 private ApplicantHibernateUtil applicantHibernateUtil;
	 
	public boolean createEmployee(ApplicantProfile employee,List<ApplicantProjects> projs,ApplicantResume resumeobj) {
		 return applicantHibernateUtil.create(employee,projs,resumeobj);
	}
	 
	public List<CompleteApplicant> getAllemp()
	{
		List<ApplicantProfile> profiles = applicantHibernateUtil.fetchAll();
		return returnEmployees(profiles);
	}

	/*public void storeResume(EmpResume resume)
	{
		hibernateUtil.storeResume(resume);
	}*/
	
	
	public void deleteEmployeeByid(String id)
	{
		applicantHibernateUtil.deleteEmployeeByid(id);
	}
	
	public List<CompleteApplicant> searchEmployeeByName(String firstname)
	{
		List<ApplicantProfile> profiles = applicantHibernateUtil.search("firstname",firstname);
		return returnEmployees(profiles);
	}
	
	public List<CompleteApplicant> searchEmployeeByContact(String contact)
	{
		List<ApplicantProfile> profiles = applicantHibernateUtil.search("contact",contact);
		return returnEmployees(profiles);
	}
	
	public List<CompleteApplicant> searchEmployeeBySkillset(String skillset)
	{
		List<ApplicantProfile> profiles = applicantHibernateUtil.search("skillset",skillset);
		return returnEmployees(profiles);
		
	}
	
	public CompleteApplicant getEmployee(String id)
	{
		ApplicantProfile emp = applicantHibernateUtil.getEmployee(id);
		List<ApplicantProjects> projects= applicantHibernateUtil.fetchprojects(emp.getContact());
		CompleteApplicant employee = new CompleteApplicant();
		employee.setEmp(emp);
		employee.setProjects(projects);
		return employee;
	}
	
	public List<CompleteApplicant> returnEmployees(List<ApplicantProfile> profiles)
	{
		List<CompleteApplicant> employees = new ArrayList<CompleteApplicant>();
		for(int i = 0;i<profiles.size();i++){
			List<ApplicantProjects> projects= applicantHibernateUtil.fetchprojects(profiles.get(i).getContact());
			CompleteApplicant employee = new CompleteApplicant();
			employee.setEmp(profiles.get(i));
			employee.setProjects(projects);
			employees.add(employee);
		}
		return employees;
	}

	public ApplicantResume getEmployeeResume(String id) {
		return applicantHibernateUtil.getEmployeeResume(id);
	}
}
