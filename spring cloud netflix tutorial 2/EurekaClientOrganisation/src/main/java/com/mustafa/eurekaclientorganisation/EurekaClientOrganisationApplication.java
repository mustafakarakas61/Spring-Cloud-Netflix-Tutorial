package com.mustafa.eurekaclientorganisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientOrganisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientOrganisationApplication.class, args);
	}

}
