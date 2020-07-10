package com.ajaytech.code.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ajaytech.code.admissionservice.DiseasesList;
import com.ajaytech.code.admissionservice.EmployeesList;
import com.ajaytech.code.admissionservice.models.Patient;

@RestController
@RequestMapping(value="/admissions")
public class AdmissionsResource 
{
	@Autowired
	private RestTemplate restTemplate;
	
	List<Patient> patients=Arrays.asList(
			new Patient("p1","Ajay","Latur"),
			new Patient("p2","Ajay","Pune"),
			new Patient("p3","Sanjay","Mumbai"),
			new Patient("p4","JAy","Thane"),
			new Patient("p5","Sagar","Latur"),
			new Patient("p6","Rupesh","Pune"),
			new Patient("p7","Sanjay","Dadar")
			
			);
	
	
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians()
	{
		EmployeesList employeesList=
		restTemplate.getForObject("http://localhost:4242/hr/employees", EmployeesList.class);
		return employeesList;
	}
	
	@RequestMapping("/diseases")
	public DiseasesList getDisease()
	{
		DiseasesList diseasesList=
		restTemplate.getForObject("http://localhost:4343/pathology/disease", DiseasesList.class);
		return diseasesList;
	}
	
	
	@RequestMapping("/patients")
	public List<Patient> getPatients()
	{
		return patients;
		
	}
	
	@RequestMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") String id)
	{
		Patient p=patients.stream()
				.filter(patient -> id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		
		return p;
		
	}
}
