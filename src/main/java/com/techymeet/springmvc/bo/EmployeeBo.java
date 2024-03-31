package com.techymeet.springmvc.bo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class EmployeeBo {
    
	private int empId;
	@NotBlank(message = "EmployeeName is Required")
	@NotEmpty(message = "EmployeeName cannot be empty")
	@Pattern(regexp="^[a-zA-Z]+$",message = "EmployeeName must be characters")
	private String empName;
	@NotBlank(message="Email is Required")
	@NotEmpty(message="Email can't be empty")
	@Pattern( message = "please enter valid email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@NotBlank(message = "Address is Required")
	@NotEmpty(message = "Address cannot be empty")
	private String address;
	@Range(min=777777777 , message="Please enter 10 digits only")
	@Digits(integer=10,fraction=0, message="Please enter 10 digits only")
	private long phoneNumber;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
}
