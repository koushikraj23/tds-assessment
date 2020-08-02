package com.assessment.tds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.tds.repository.EmployeeRepo;
import com.assessment.tds.model.*;



@RestController
@RequestMapping(path = "/GET")

public class EmployeeController 
{
	  @Autowired
	    private EmployeeRepo employeeRepository;

	  @RequestMapping(value = "/employees", method = RequestMethod.GET)
	    public List < Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
	  @RequestMapping(value = "/staus", method = RequestMethod.GET)
	    public List < Employee> getAvEmployees() {
	        return employeeRepository.findByLeaveDateIsNull();
	    }
  
   
}