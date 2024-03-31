package com.techymeet.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techymeet.springmvc.bo.EmployeeBo;
import com.techymeet.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/")
	  public ModelAndView getIndex() {
		  
		ModelAndView model=new ModelAndView("create_employee");
		model.addObject("employee", new EmployeeBo());
		  return model;
		  
	  }
	
	@PostMapping(path="create-employee")
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") EmployeeBo employee,BindingResult result)  {
			// TODO Auto-generated method stub
		ModelAndView model=null; 
		if(result.hasErrors()) {
			 model =new ModelAndView("create_employee");
			 return model;
		}
		try {
		   employee=employeeservice.addEmployee(employee);
		    if(null!=employee) {
		    	 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Created Successfully!");
				 
			}else {
				 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Was Not Added");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		}
	
	@GetMapping("/update")
	  public ModelAndView getEmployeeById(@RequestParam("Id") int id) {
		ModelAndView model=null;
		
		EmployeeBo employee=employeeservice.getEmployeeById(id);
		 if(null!=employee) {
			 model=new ModelAndView( "update_employee");
				model.addObject("employeebo",employee);
		 }else {
			 model=new ModelAndView( "update_employee");
		 }
		  
		  return model;
	  }
	@PostMapping("update-employee")
	public ModelAndView updateEmployee(HttpServletRequest request,@ModelAttribute("employee") EmployeeBo employee)  {
			// TODO Auto-generated method stub
		ModelAndView model=null;
		int id=Integer.parseInt(request.getParameter("empId"));
		employee.setEmpId(id);
		try {
		   employee=employeeservice.updateEmployee(employee);
		    if(null!=employee) {
		    	 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Updated Successfully!");
				 
			}else {
				 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Details Was Not Updated");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		}
	
	@GetMapping("/employee-list")
	  public ModelAndView viewEmployee(HttpServletRequest request) {
		ModelAndView model=null;
		try {
		List<EmployeeBo> employees=employeeservice.getAllEmployees();
		if(null!=employees&&employees.size()>0&&!employees.isEmpty()) {
			model=new ModelAndView( "employee_list");
			model.addObject("employeeList",employees);
			if(null!=request.getParameter("errorMessage")){
				request.setAttribute("errorMessage", request.getParameter("errorMessage"));
			}
		}else {
			model=new ModelAndView( "create_employee");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		  return model;
	  }
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id)  {
		
		ModelAndView model=null;
		try {
			int empId=employeeservice.deleteEmployeeById(id);
			 if(empId>0) {
		    	 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Deleted Successfully!");
				 
			}else {
				 model =new ModelAndView("redirect:/employee-list");
				 model.addObject("errorMessage", " Employee Details Was Not deleted");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
