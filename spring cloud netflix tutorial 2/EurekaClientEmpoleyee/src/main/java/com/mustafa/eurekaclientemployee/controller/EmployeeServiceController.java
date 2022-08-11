package com.mustafa.eurekaclientemployee.controller;

import com.mustafa.eurekaclientemployee.helper.EurekaClientEmpServiceContributor;
import com.mustafa.eurekaclientemployee.model.Employee;
import org.springframework.boot.actuate.info.Info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeServiceController {

    private static Map<String, List<Employee>> company = new HashMap<String, List<Employee>>();

    static {
        company = new HashMap<String, List<Employee>>();

        List<Employee> record = new ArrayList<Employee>();
        Employee e1 = new Employee("Rajesh Gopinathan", "CEO");
        record.add(e1);
        Employee e2 = new Employee("Nataraj Chandrashekharan", "Chairperson");

        record.add(e2);

        Employee e3 = new Employee("Samir Sekaria", "CFO");

        record.add(e3);

        company.put("Tata Consultancy Services", record);

        record = new ArrayList<Employee>();
        e1 = new Employee("Salil Parekh", "CEO");
        record.add(e1);
        e2 = new Employee("NR Narayan Murthy", "Chairperson");
        record.add(e2);
        e3 = new Employee("Nilanjan Roy", "CFO");
        record.add(e3);

        company.put("INFOSYS", record);

    }



    @RequestMapping(value = "/getEmployeeDetails/{companyname}", method = RequestMethod.GET)
    public List<Employee> getEmployees(@PathVariable String companyname) {
        System.out.println("Getting Employee details for " + companyname);

        List<Employee> empList = company.get(companyname);
        if (empList == null) {
            empList = new ArrayList<Employee>();
            Employee std = new Employee("Not Found", "N/A");
            empList.add(std);
        }
        return empList;
    }

}
