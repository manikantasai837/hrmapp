package com.hrm.hrmapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	private Long id;
	private String name;
	private String designation;
	@Column(name = "doj")
	private Date yearOfJoining;
	private String address;

	public Employee() {
	}

	public Employee(Long id, String name, String designation, Date yearOfJoining, String address) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.yearOfJoining = yearOfJoining;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(Date yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
