package com.techymeet.springmvc.dao;

import java.util.List;

import com.techymeet.springmvc.vo.EmployeeVo;

public interface EmployeeDao {

	EmployeeVo addEmployee(EmployeeVo employeevo);

	List<EmployeeVo> getAllEmployees();

	EmployeeVo getEmployeeById(int id);

	EmployeeVo updateEmployee(EmployeeVo employeevo);

	int deleteEmployeeById(int id);

}
