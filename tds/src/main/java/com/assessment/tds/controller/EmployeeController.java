package com.assessment.tds.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import com.assessment.tds.repository.BadgeRepo;
import com.assessment.tds.repository.DepartmentRepo;
import com.assessment.tds.repository.EmployeeRepo;
import com.assessment.tds.repository.JobTitleRepo;
import com.assessment.tds.dao.BadgeResponse;
import com.assessment.tds.dao.DepartmentResponse;
import com.assessment.tds.dao.EmployeeResponse;
import com.assessment.tds.dao.JobResponse;
import com.assessment.tds.exceptions.CustomError;
import com.assessment.tds.model.*;

@RestController
@RequestMapping(path = "/GET")

public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepository;
	@Autowired
	private BadgeRepo badgeRepository;
	@Autowired
	private DepartmentRepo departmentRepository;
	@Autowired
	private JobTitleRepo jobTitleRepository;

	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<DepartmentResponse> getAllDepartments() {

		return departmentRepository.findAllProjectedBy();
	}

	@RequestMapping(value = "/badges", method = RequestMethod.GET)
	public List<BadgeResponse> getBadgeDetails(
			@RequestParam(required = false, name = "badge_number") Long badgeNumber) {
		
		
		if (badgeNumber != null) {
			List<BadgeResponse> response=badgeRepository.findByBadgeNo(badgeNumber);
			if(response.isEmpty()) {
				throw new ResponseStatusException(
						  HttpStatus.NOT_FOUND, "No badge details available for the ID"
						);
			}
			return response;
		} else {
			return badgeRepository.findAllProjectedBy();
		}

	}

	@RequestMapping(value = "/badges/active", method = RequestMethod.GET)
	public List<BadgeResponse> getActiveBadges() {

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		List<BadgeResponse> response= badgeRepository.findByBadgeStatusAndExpiryDateAfter("Active", date);
		if(response.isEmpty()) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No badges where found active!!!"
					);
		}
		
		return response;
	}

	

	@RequestMapping(value = "/job_titles")
	public List<JobResponse> getAllJobTitles(@RequestParam(required = false, name = "departmentName") String departmentName) {
		if (departmentName != null) {
			return jobTitleRepository.findByDepartmentDepartmentName(departmentName);
		} else {

			return jobTitleRepository.findAllProjectedBy();

		}

	}
	
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<EmployeeResponse> getEmployeesDetails(@RequestParam(required = false, name = "department") String department) {
		if(!department.isEmpty()) {
			
			boolean departmentValidation=departmentRepository.existsByDepartmentName(department);
			if(!departmentValidation) {
				throw new MethodArgumentTypeMismatchException(null, null, department, null, null);
			}
			List<EmployeeResponse> response=employeeRepository.findByJobTitleDepartmentDepartmentName(department);
			if(response.isEmpty()) {
				throw new ResponseStatusException(
						  HttpStatus.NOT_FOUND, "No Employees where found!!! Please provide a valid department"
						);
			}
			return response;
		}
		else {
			return employeeRepository.findAllProjectedBy();
		}
		
	}


	@RequestMapping(value = "/employees/active", method = RequestMethod.GET)
	public List<EmployeeResponse> getActiveEmployees() {
		Date date = new Date(Calendar.getInstance().getTime().getTime());

		return employeeRepository.findByLeaveDateIsNullOrLeaveDateAfter(date);
	}

	
	

	/*
	 * @RequestMapping(value = "/badges", method = RequestMethod.GET) public
	 * List<Badge> getBadgeByID(@RequestParam(required = false,name="badge_number")
	 * Long badge_number) {
	 * 
	 * 
	 * return badgeRepository.findByBadgeNo(badge_number); }
	 */
	

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e,
			WebRequest request) {
		StringBuffer error=new StringBuffer();
		error.append(e.getName());
if(error.toString().equalsIgnoreCase("badge_number")) {
	error.append("contains non numerical character");}
else {
	error.append("-is not a valid department");
}

		CustomError customError = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY, error.toString());
		return new ResponseEntity<Object>(customError, new HttpHeaders(), customError.getHttpStatus());
	}
}