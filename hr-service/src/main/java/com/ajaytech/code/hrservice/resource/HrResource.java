package com.ajaytech.code.hrservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajaytech.code.hrservice.models.Employee;
import com.ajaytech.code.hrservice.models.EmployeesList;

@RestController
@RequestMapping(value="/hr")
public class HrResource 
{
	public List<Employee> employee= Arrays.asList(
			new Employee("E1","Ajay","Shinde","Meditech"),
			new Employee("E2","AAaay","Shinde","Denties"),
			new Employee("E3","Sanjay","shelake","MediTech"),
			new Employee("E4","jay","jadhav","physician")
			
			);

	@RequestMapping("/employees")
	public EmployeesList getEmployee()
	{
		EmployeesList employeesList=new EmployeesList();
		employeesList.setEmployees(employee);
		return employeesList;
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id")String id)
	{
		Employee e=employee.stream()
				.filter(employee -> id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		return e;
				
	}
	
}
