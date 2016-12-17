/**
 * @author mk186084
 *
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

@RestController
@Configuration
@ComponentScan("com.mywork.resumeprocessing.service")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService; 
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public void addEmp(@RequestParam("resume") CommonsMultipartFile resume,@RequestParam("employee") String stremployee)throws IOException
	{
		System.out.println("File name:"+ resume.getOriginalFilename());
		System.out.println("JSON String:"+stremployee);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		CompleteEmployee employee = mapper.readValue(stremployee, CompleteEmployee.class);
		EmpResume resumeobj = new EmpResume();
		resumeobj.setContact(employee.getEmp().getContact());
		resumeobj.setEmpresume(resume.getBytes());
		
		employeeService.deleteEmployeeByid(employee.getEmp().getContact());
		employeeService.createEmployee(employee);
		employeeService.storeResume(resumeobj);
	}
	
	
	
	@RequestMapping(value= "/retrieveAllEmps", method =RequestMethod.POST)
	public List<CompleteEmployee> getAllEmps()
	{
		return employeeService.getAllEmps();
	}
	
	
	@RequestMapping(value= "/deleteEmployee", method =RequestMethod.POST)
	public void deleteEmployee(@RequestBody String id)
	{
		employeeService.deleteEmployeeByid(id);
	}
	
	@RequestMapping(value= "/searchByName", method =RequestMethod.POST)
	public List<CompleteEmployee> searchEmployeeByName(@RequestBody String firstname)
	{
		return employeeService.searchEmployeeByName(firstname);
	}
	
	@RequestMapping(value= "/searchByContact", method =RequestMethod.POST)	
	public List<CompleteEmployee> searchEmployeeByContact(@RequestBody String contact)
	{
		return employeeService.searchEmployeeByContact(contact);
	}
	
	@RequestMapping(value= "/searchBySkillset", method =RequestMethod.POST)	
	public List<CompleteEmployee> searchEmployeeBySkillset(@RequestBody String skill)
	{
		return employeeService.searchEmployeeBySkillset(skill);
	}
	
	@RequestMapping(value= "/editEmployee", method =RequestMethod.POST)	
	public CompleteEmployee getEmployee(@RequestBody String id)
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
