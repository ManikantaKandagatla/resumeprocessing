package com.mywork.resumeprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.dao.EmpDAO;
import com.mywork.resumeprocessing.model.CompleteEmployee;
import com.mywork.resumeprocessing.model.EmpResume;



@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmpDAO empDAO;
	// private RestTemplate restTemplate = null;
	
	public void createEmployee(CompleteEmployee employee)
	{
		empDAO.createEmployee(employee.getEmp(),employee.getProjects());
	}
	
	public List<CompleteEmployee> getAllEmps()
	{
		return empDAO.getAllemp();
	}
	
	
	
	public void deleteEmployeeByid(String id) {
        empDAO.deleteEmployeeByid(id);
    }
 
	public List<CompleteEmployee> searchEmployeeByName(String firstname) {
        return empDAO.searchEmployeeByName(firstname);
    }
	public List<CompleteEmployee> searchEmployeeByContact(String contact) {
       return  empDAO.searchEmployeeByContact(contact);
    }
	public List<CompleteEmployee> searchEmployeeBySkillset(String skillset) {
        return empDAO.searchEmployeeBySkillset(skillset);
    }
 
	public CompleteEmployee getEmployee(String id){
		return empDAO.getEmployee(id);
	}
	
	public EmpResume getEmployeeResume(String id){
		return empDAO.getEmployeeResume(id);
	}
	
	public void storeResume(EmpResume resumeobj) {
		empDAO.storeResume(resumeobj);
	}
	
	
}
