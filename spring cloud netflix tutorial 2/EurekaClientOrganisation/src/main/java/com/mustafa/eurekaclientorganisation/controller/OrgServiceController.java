package com.mustafa.eurekaclientorganisation.controller;


import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrgServiceController {
    @Autowired
    @Lazy
    RestTemplate restTemplate;

    @RequestMapping(
            value = "/getOrgDetails/{companyname}",
            method = RequestMethod.GET)
    public String getStudents(@PathVariable String companyname) {
        String response = restTemplate.exchange("http://employee-service/getEmployeeDetails/{companyname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, companyname).getBody();


        return "<b>Company Name</b> -  " + companyname + " \n\n <b>Employee Details</b> " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
