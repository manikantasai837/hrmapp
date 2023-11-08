package com.hrm.hrmapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.hrmapp.dto.EmployeeAddDTO;
import com.hrm.hrmapp.dto.EmployeeDTO;
import com.hrm.hrmapp.entity.Employee;
import com.hrm.hrmapp.repository.EmployeeRepositiory;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepositiory empRepositiory;

//	public List<Employee> getAllEmployeeData()
//	{
//		return empRepositiory.findAll();
//	}

	public List<EmployeeDTO> getAllEmployeeData() {
		List<Employee> empList = empRepositiory.findAll();
		List<EmployeeDTO> empDtoList = empList.stream().map(employee -> buildEmplyoeeDTO(employee))
				.collect(Collectors.toList());

		return empDtoList;
	}

	public void addEmployee(EmployeeAddDTO employeeaddDto) {
		
		Employee employee = buildEmplyoeeEntity(employeeaddDto);
		empRepositiory.save(employee);
	}

	public void delEmployee(long id) {
		empRepositiory.deleteById(id);
	}

	private EmployeeDTO buildEmplyoeeDTO(Employee employee) { // ENTITY to DTO

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setFullName(employee.getName());
		employeeDTO.setAddress(employee.getAddress());
		
		//set other fileds
		

		return employeeDTO;
	}

	private Employee buildEmplyoeeEntity(EmployeeAddDTO employeeAddDTO) { // DTO to ENTITY

		Employee employee = new Employee();
		employee.setId(employeeAddDTO.getId());
		employee.setAddress(employeeAddDTO.getAddress());
		employee.setName(employeeAddDTO.getFullName());
		
		return employee;
	}

}
