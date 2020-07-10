package com.ajaytech.code.hrservice.models;

public class Employee {

	private String Id;
	private String firstname;
	private String lastname;
	private String department;
	
	public Employee()
	{
		
	}

	public Employee(String id, String firstname, String lastname, String department) {
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
