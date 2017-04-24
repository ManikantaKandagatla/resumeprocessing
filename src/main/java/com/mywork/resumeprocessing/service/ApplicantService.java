/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.resumeprocessing.dao.ApplicantDAO;
import com.mywork.resumeprocessing.model.applicant.CompleteApplicant;
import com.mywork.resumeprocessing.model.applicant.ApplicantResume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class ApplicantService {

	private static final Logger log = LoggerFactory.getLogger(ApplicantService.class);
	@Autowired
	private ApplicantDAO applicantDAO;
	// private RestTemplate restTemplate = null;
	
	public boolean createEmployee(CompleteApplicant employee,ApplicantResume resumeobj)
	{
		log.info("Adding Employee..!!");
		return applicantDAO.createEmployee(employee.getEmp(),employee.getProjects(),resumeobj);
	}
	
	public List<CompleteApplicant> getAllEmps()
	{
		log.info("Retrieving Employees..!!");
		return applicantDAO.getAllemp();
	}
	
	
	
	public void deleteEmployeeByid(String id) {
		log.info("Deleting Employee with id: "+id+"..!!");
        applicantDAO.deleteEmployeeByid(id);
    }
 
	public List<CompleteApplicant> searchEmployeeByName(String firstname) {
		log.info("Search Employee by Name: "+ firstname);
        return applicantDAO.searchEmployeeByName(firstname);
    }
	public List<CompleteApplicant> searchEmployeeByContact(String contact) {
		log.info("Search Employee by contact: "+contact);
		return  applicantDAO.searchEmployeeByContact(contact);
    }
	public List<CompleteApplicant> searchEmployeeBySkillset(String skillset) {
		log.info("Search Employee by skillset: "+skillset);
        return applicantDAO.searchEmployeeBySkillset(skillset);
    }
 
	public CompleteApplicant getEmployee(String id){
		log.info("Fetching Applicants complete details..!!");
		return applicantDAO.getEmployee(id);
	}
	
	public ApplicantResume getEmployeeResume(String id){
		log.info("Fetching resume of Applicant..!!");
		return applicantDAO.getEmployeeResume(id);
	}
	
	/*public void storeResume(EmpResume resume) {
		empDAO.storeResume(resume);
	}*/
	
	
}
