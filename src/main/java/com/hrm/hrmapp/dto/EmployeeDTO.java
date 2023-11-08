package com.hrm.hrmapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDTO {

	private long id;
	private String fullName;
	
	@NotBlank(message="Address should not be blanl/empty")
	@NotNull(message="Address should not be null")
	private String address;
	
	public EmployeeDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
