/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mywork.resumeprocessing.model.applicant.CompleteApplicant;
import com.mywork.resumeprocessing.model.applicant.ApplicantResume;
import com.mywork.resumeprocessing.model.commons.Mail;
import com.mywork.resumeprocessing.service.ApplicantService;
import com.mywork.resumeprocessing.service.MailService;

import org.apache.log4j.Logger; 

@RestController
@EnableWebMvc
@Configuration
@ComponentScan("com.mywork.resumeprocessing.service")
public class ApplicantController {
	
	private static final Logger log = Logger.getLogger(ApplicantController.class);
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired 
	private MailService mailService;
	
	private Mail mail = null;
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.POST)
	public String addEmp(@RequestParam("resume") CommonsMultipartFile resume,@RequestParam("employee") String stremployee)throws IOException
	{
		boolean success = true;
		log.info("File name:"+ resume.getOriginalFilename());
		log.info("JSON String:"+stremployee);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CompleteApplicant employee = mapper.readValue(stremployee, CompleteApplicant.class);

		System.out.println(resume.getSize());
		ApplicantResume resumeobj = new ApplicantResume();
		resumeobj.setEmpprofile(employee.getEmp());
		resumeobj.setEmpresume(resume.getBytes());
		applicantService.deleteEmployeeByid(employee.getEmp().getContact());
		success = applicantService.createEmployee(employee,resumeobj);
		if(success)
		{
			mail = new Mail();
			mail.setSubject("Notifiation: Applicant" + employee.getEmp().getFirstname()+ "created successfully");
			mail.setToAddress("kanta.123479@gmail.com");
			mail.setBody("The details are added into the Repository..!!");
			mailService.sendHtmlMail(mail);
			return "Employee Created successfully";
		}
		else 
		{
			return "Error Creating Employee";
		}
	}
	
	
	
	@RequestMapping(value= "/retrieveAllApplicants", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	public @ResponseBody List<CompleteApplicant> getAllEmps()
	{
		log.info("Retrieving all employees");
		List<CompleteApplicant> allEmps = applicantService.getAllEmps();
		log.info("Retrieved " +allEmps.size()+" employees");
		return allEmps;
	}
	
	
	@RequestMapping(value= "/deleteEmployee", method =RequestMethod.POST)
	public void deleteEmployee(@RequestBody String id)
	{
		log.info("Retrieving all employees");
		applicantService.deleteEmployeeByid(id);
	}
	
	@RequestMapping(value= "/searchByName/{firstname}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	public @ResponseBody List<CompleteApplicant> searchEmployeeByName(@PathVariable String firstname)
	{
		return applicantService.searchEmployeeByName(firstname);
	}
	
	@RequestMapping(value= "/searchByContact/{contact}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")	
	public @ResponseBody List<CompleteApplicant> searchEmployeeByContact(@PathVariable  String contact)
	{
		return applicantService.searchEmployeeByContact(contact);
	}
	
	@RequestMapping(value= "/searchBySkillset/{skill}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")	
	public @ResponseBody List<CompleteApplicant> searchEmployeeBySkillset(@PathVariable String skill)
	{
		skill = skill.replace('*', '%');
		return applicantService.searchEmployeeBySkillset(skill);
	}
	
	@RequestMapping(value= "/editEmployee", method =RequestMethod.POST)	
	public @ResponseBody CompleteApplicant getEmployee(@RequestBody String id)
	{
		return applicantService.getEmployee(id);
	}
	
	@RequestMapping(value="/getApplicantResume/{id}",method = RequestMethod.GET,produces = "application/pdf")
	public @ResponseBody byte[]  getApplicantResume(@PathVariable String id,HttpServletResponse response)
	{
		ApplicantResume resume = applicantService.getEmployeeResume(id);
		byte[] content = resume.getEmpresume();
		System.out.println(content.length);
		response.setHeader("Content-Disposition", "inline; filename=Empresume.pdf");
	    response.setContentType("application/pdf");
	    return content;
	}
}
