/**
 * @author ManiKanta Kandagatla
 */
package com.mywork.resumeprocessing.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
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

import com.mywork.resumeprocessing.model.CompleteEmployee;
import com.mywork.resumeprocessing.model.EmpResume;
import com.mywork.resumeprocessing.service.EmployeeService;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Configuration
@ComponentScan("com.mywork.resumeprocessing.service")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmp(@RequestParam("resume") CommonsMultipartFile resume,@RequestParam("employee") String stremployee)throws IOException
	{
		boolean success = true;
		log.info("File name:"+ resume.getOriginalFilename());
		log.info("JSON String:"+stremployee);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CompleteEmployee employee = mapper.readValue(stremployee, CompleteEmployee.class);

		System.out.println(resume.getSize());
		EmpResume resumeobj = new EmpResume();
		resumeobj.setEmpprofile(employee.getEmp());
		resumeobj.setEmpresume(resume.getBytes());
		employeeService.deleteEmployeeByid(employee.getEmp().getContact());
		success = employeeService.createEmployee(employee,resumeobj);
		if(success)
			return "Employee Created successfully";
		else return "Error Creating Employee";
	}
	
	
	
	@RequestMapping(value= "/retrieveAllEmps", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	public @ResponseBody List<CompleteEmployee> getAllEmps()
	{
		log.info("Retrieving all employees");
		List<CompleteEmployee> allEmps = employeeService.getAllEmps();
		log.info("Retrieved " +allEmps.size()+" employees");
		return allEmps;
	}
	
	
	@RequestMapping(value= "/deleteEmployee", method =RequestMethod.POST)
	public void deleteEmployee(@RequestBody String id)
	{
		log.info("Retrieving all employees");
		employeeService.deleteEmployeeByid(id);
	}
	
	@RequestMapping(value= "/searchByName/{firstname}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")
	public @ResponseBody List<CompleteEmployee> searchEmployeeByName(@PathVariable String firstname)
	{
		return employeeService.searchEmployeeByName(firstname);
	}
	
	@RequestMapping(value= "/searchByContact/{contact}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")	
	public @ResponseBody List<CompleteEmployee> searchEmployeeByContact(@PathVariable  String contact)
	{
		return employeeService.searchEmployeeByContact(contact);
	}
	
	@RequestMapping(value= "/searchBySkillset/{skill}", method =RequestMethod.GET,produces = "application/json",headers="Accept=*/*")	
	public @ResponseBody List<CompleteEmployee> searchEmployeeBySkillset(@PathVariable String skill)
	{
		return employeeService.searchEmployeeBySkillset(skill);
	}
	
	@RequestMapping(value= "/editEmployee", method =RequestMethod.POST)	
	public @ResponseBody CompleteEmployee getEmployee(@RequestBody String id)
	{
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(value="/getEmpResume/{id}",method = RequestMethod.GET,produces = "application/pdf")
	public @ResponseBody byte[]  getEmployeeResume(@PathVariable String id,HttpServletResponse response)
	{
		EmpResume resume = employeeService.getEmployeeResume(id);
		byte[] content = resume.getEmpresume();
		System.out.println(content.length);
		response.setHeader("Content-Disposition", "inline; filename=Empresume.pdf");
	    response.setContentType("application/pdf");
	    return content;
	}
}
