package com.ajaytech.code.admissionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient
@SpringBootApplication
public class AdmissionServiceApplication {

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(AdmissionServiceApplication.class, args);
	}

}
