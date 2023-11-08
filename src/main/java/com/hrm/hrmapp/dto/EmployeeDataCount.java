package com.hrm.hrmapp.dto;



import java.util.List;

import com.hrm.hrmapp.entity.Employee;


public class EmployeeDataCount {

	private long empCount;
	private List<Employee> empList;
	
	
	
	public long getEmpCount() {
		return empCount;
	}
	public void setEmpCount(long empCount) {
		this.empCount = empCount;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

}
