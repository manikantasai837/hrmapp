package com.hrm.hrmapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hrm.hrmapp.dto.EmployeeAddDTO;
import com.hrm.hrmapp.dto.EmployeeDTO;
import com.hrm.hrmapp.service.EmployeeService;

@RestController
public class EmployeeController { // Delegation logic

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/allemployeedata", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<EmployeeDTO> getAllEmployee() {

		return employeeService.getAllEmployeeData();
	}

	// JSON to JAVA // JAVA to JSON -> Jackson mapper

	@PostMapping("/addemployee")
	public void addEmployee(@RequestBody @Valid EmployeeAddDTO employee) {

		employeeService.addEmployee(employee);
	}

	/*
	 * @GetMapping(("/countofemployees")) public Map<String, Object>
	 * countOfEmployees() { Map<String, Object> map = new LinkedHashMap<>();
	 * map.put("employeeCount", getAllEmployee().size()); map.put("employeeData",
	 * getAllEmployee());
	 * 
	 * return map;
	 * 
	 * }
	 */

//	@GetMapping(("/countofemployeeswithclass"))
//	public Map<String,Object> countOfEmployeesWithClass() {
//		
//		List<Employee> empList = getAllEmployee(); 
//		int count = empList.size();
//		
//	
//		Map<String, Object> map = new HashMap<>();
//		map.put("empcount", count);
//		map.put("emplist", empList);
//		return map;
////		EmployeeDataCount empCountData = new EmployeeDataCount();
////		empCountData.setEmpCount(getAllEmployee().size());
////		empCountData.setEmpList(getAllEmployee());
////
////		return empCountData;
//
//	}
	/*
	 * @GetMapping(("/employeeNameOrder")) public List<Employee> orderAllEmployees()
	 * { List<Employee> empList = getAllEmployee(); List<Employee> sortedList =
	 * empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
	 * .collect(Collectors.toList()); return sortedList; }
	 * 
	 * @DeleteMapping("/employee/{id}") public void
	 * deleteEmployee(@PathVariable("id") long id) {
	 * employeeService.delEmployee(id); }
	 */

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
