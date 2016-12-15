package com.teradata.resumeprocessing.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teradata.resumeprocessing.model.CompleteEmployee;
import com.teradata.resumeprocessing.model.EmpProfile;
import com.teradata.resumeprocessing.model.EmpProjects;
import com.teradata.resumeprocessing.model.EmpResume;
import com.teradata.resumeprocessing.util.HibernateUtil;


@Repository
@Transactional
public class EmpDAO  {
	
	 @Autowired
	 private HibernateUtil hibernateUtil;
	 
	public void createEmployee(EmpProfile employee,List<EmpProjects> projs) {
		 hibernateUtil.create(employee,projs);
	}
	 
	public List<CompleteEmployee> getAllemp()
	{
		List<EmpProfile> profiles = hibernateUtil.fetchAll();
		return returnEmployees(profiles);
	}

	public void storeResume(EmpResume resume)
	{
		hibernateUtil.storeResume(resume);
	}
	
	
	public void deleteEmployeeByid(String id)
	{
		hibernateUtil.deleteEmployeeByid(id);
	}
	
	public List<CompleteEmployee> searchEmployeeByName(String firstname)
	{
		List<EmpProfile> profiles = hibernateUtil.search("firstname",firstname);
		return returnEmployees(profiles);
	}
	
	public List<CompleteEmployee> searchEmployeeByContact(String contact)
	{
		List<EmpProfile> profiles = hibernateUtil.search("contact",contact);
		return returnEmployees(profiles);
	}
	
	public List<CompleteEmployee> searchEmployeeBySkillset(String skillset)
	{
		List<EmpProfile> profiles = hibernateUtil.search("skillset",skillset);
		return returnEmployees(profiles);
		
	}
	
	public CompleteEmployee getEmployee(String id)
	{
		EmpProfile emp = hibernateUtil.getEmployee(id);
		List<EmpProjects> projects= hibernateUtil.fetchprojects(emp.getContact());
		CompleteEmployee employee = new CompleteEmployee();
		employee.setEmp(emp);
		employee.setProjects(projects);
		return employee;
	}
	
	public List<CompleteEmployee> returnEmployees(List<EmpProfile> profiles)
	{
		List<CompleteEmployee> employees = new ArrayList<CompleteEmployee>();
		for(int i = 0;i<profiles.size();i++){
			List<EmpProjects> projects= hibernateUtil.fetchprojects(profiles.get(i).getContact());
			CompleteEmployee employee = new CompleteEmployee();
			employee.setEmp(profiles.get(i));
			employee.setProjects(projects);
			employees.add(employee);
		}
		return employees;
	}

	public EmpResume getEmployeeResume(String id) {
		return hibernateUtil.getEmployeeResume(id);
	}
}
