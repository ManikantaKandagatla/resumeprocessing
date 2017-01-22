/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.dao.EmpDAO;
import com.mywork.resumeprocessing.model.CompleteEmployee;
import com.mywork.resumeprocessing.model.EmpResume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	private EmpDAO empDAO;
	// private RestTemplate restTemplate = null;
	
	public boolean createEmployee(CompleteEmployee employee,EmpResume resumeobj)
	{
		log.info("Adding Employee..!!");
		return empDAO.createEmployee(employee.getEmp(),employee.getProjects(),resumeobj);
	}
	
	public List<CompleteEmployee> getAllEmps()
	{
		log.info("Retrieving Employees..!!");
		return empDAO.getAllemp();
	}
	
	
	
	public void deleteEmployeeByid(String id) {
		log.info("Deleting Employee with id: "+id+"..!!");
        empDAO.deleteEmployeeByid(id);
    }
 
	public List<CompleteEmployee> searchEmployeeByName(String firstname) {
		log.info("Search Employee..!!");
        return empDAO.searchEmployeeByName(firstname);
    }
	public List<CompleteEmployee> searchEmployeeByContact(String contact) {
		log.info("Search Employee..!!");
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
	
	/*public void storeResume(EmpResume resume) {
		empDAO.storeResume(resume);
	}*/
	
	
}
