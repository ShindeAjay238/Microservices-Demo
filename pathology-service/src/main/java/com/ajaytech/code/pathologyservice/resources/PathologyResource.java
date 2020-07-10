package com.ajaytech.code.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajaytech.code.pathologyservice.models.Disease;
import com.ajaytech.code.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource
{
	List<Disease> disease=Arrays.asList(
			new Disease("D1","Asthma","ware wather bath"),
			new Disease("D2","Thyphold","Aaplician capsules"),
			new Disease("D3","cold","CiplaCold")			
			);
	
	@RequestMapping("/diseases")
	public DiseasesList getDiseases()
	{
		DiseasesList diseasesList=new DiseasesList();
		diseasesList.setDiseases(disease);
		return diseasesList;
	}
	
	@RequestMapping("/disease")
	public List<Disease> getDisease()
	{
		return disease;
	}
	
	@RequestMapping("/disease/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id)
	{
		Disease d=disease.stream()
				.filter(disease ->id.equals(disease.getId()))
				.findAny()
				.orElse(null);
		return d;
 	}

}
