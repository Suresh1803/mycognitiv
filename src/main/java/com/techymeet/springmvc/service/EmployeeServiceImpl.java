package com.techymeet.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techymeet.springmvc.bo.EmployeeBo;
import com.techymeet.springmvc.dao.EmployeeDao;
import com.techymeet.springmvc.vo.EmployeeVo;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;
	@Override
	public EmployeeBo addEmployee(EmployeeBo employee) {
		
		EmployeeVo employeevo=new EmployeeVo();
		employeevo.setEmpName(employee.getEmpName());
		employeevo.setEmail(employee.getEmail());
		employeevo.setAddress(employee.getAddress());
		employeevo.setPhoneNumber(employee.getPhoneNumber());
		employeevo=employeedao.addEmployee(employeevo);
		if(null!=employeevo) {
			employee.setEmpId(employeevo.getEmpId());
			return employee;
		}
		return null;
	}
	@Override
	public List<EmployeeBo> getAllEmployees() {
		List<EmployeeBo> employees=new ArrayList<EmployeeBo>();
		List<EmployeeVo> employeesvo=employeedao.getAllEmployees();
		if(null!=employeesvo&&employeesvo.size()>0&&!employeesvo.isEmpty()) {
			
			for(EmployeeVo employeevo:employeesvo) {
				EmployeeBo employee =new EmployeeBo();
				employee.setEmpId(employeevo.getEmpId());
				employee.setEmpName(employeevo.getEmpName());
				employee.setEmail(employeevo.getEmail());
				employee.setAddress(employeevo.getAddress());
				employee.setPhoneNumber(employeevo.getPhoneNumber());
				employees.add(employee);
				
			}
			return employees;
		}
		return null;
	}
	@Override
	public EmployeeBo getEmployeeById(int id) {
		EmployeeVo employeevo=new EmployeeVo();
		employeevo= employeedao.getEmployeeById(id);
		if(null!=employeevo) {
			EmployeeBo employee =new EmployeeBo();
			employee.setEmpId(employeevo.getEmpId());
			employee.setEmpName(employeevo.getEmpName());
			employee.setEmail(employeevo.getEmail());
			employee.setAddress(employeevo.getAddress());
			employee.setPhoneNumber(employeevo.getPhoneNumber());
			return employee;
		}
		return null;
	}
	@Override
	public EmployeeBo updateEmployee(EmployeeBo employee) {
		EmployeeVo employeevo=new EmployeeVo();
		employeevo.setEmpId(employee.getEmpId());
		employeevo.setEmpName(employee.getEmpName());
		employeevo.setEmail(employee.getEmail());
		employeevo.setAddress(employee.getAddress());
		employeevo.setPhoneNumber(employee.getPhoneNumber());
		employeevo=employeedao.updateEmployee(employeevo);
		if(null!=employeevo) {
			employee.setEmpId(employeevo.getEmpId());
			return employee;
		}
		return null;
	}
	@Override
	public int deleteEmployeeById(int id) {
		
		
		
		return employeedao.deleteEmployeeById(id);
	}

}
