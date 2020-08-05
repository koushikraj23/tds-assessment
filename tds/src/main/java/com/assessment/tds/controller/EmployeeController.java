package com.assessment.tds.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import org.springframework.web.client.RestTemplate;
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

	// Returns all Departments
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<DepartmentResponse> getAllDepartments() {

		return departmentRepository.findAllProjectedBy();
	}

	// Returns all System Badges Details and matching badge details matching badge
	// number (if given)
	@RequestMapping(value = "/badges", method = RequestMethod.GET)
	public List<BadgeResponse> getBadgeDetails(
			@RequestParam(required = false, name = "badge_number") Long badgeNumber) {

		if (badgeNumber != null) {
			if (badgeNumber < 0) {
				throw new MethodArgumentTypeMismatchException(null, null, "badge_number=" + badgeNumber.toString(),
						null, null);

			}
			List<BadgeResponse> response = badgeRepository.findByBadgeNo(badgeNumber);
			if (response.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No badge details available for Id=" + badgeNumber);
			}
			return response;
		} else {
			return badgeRepository.findAllProjectedBy();
		}

	}

	// Return only Active badge details
	@RequestMapping(value = "/badges/active", method = RequestMethod.GET)
	public List<BadgeResponse> getActiveBadges() {

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		List<BadgeResponse> response = badgeRepository.findByBadgeStatusAndExpiryDateAfter("Active", date);
		if (response.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No badges where found active!!!");
		}

		return response;
	}

	// Return all job title details
	@RequestMapping(value = "/job_titles")
	public List<JobResponse> getAllJobTitles() {

		return jobTitleRepository.findAllProjectedBy();

	}

	// Return job title details of a specific department
	@RequestMapping(value = "/job_titles/:{departmentName}", method = RequestMethod.GET)
	public List<JobResponse> getJobTitles(@PathVariable("departmentName") String departmentName) {
		System.out.println(departmentName);

		if (!departmentName.isEmpty()) {
			boolean departmentValidation = departmentRepository.existsByDepartmentNameIgnoreCase(departmentName);

			if (!departmentValidation) {
				throw new MethodArgumentTypeMismatchException(null, null, departmentName, null, null);
			} else {
				List<JobResponse> response = jobTitleRepository
						.findByDepartmentDepartmentNameIgnoreCase(departmentName);

				if (response.isEmpty()) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,
							"No Job Titles where found for the department!!!");
				}
				return response;
			}

		} else {

			throw new MethodArgumentTypeMismatchException(null, null, departmentName, null, null);
		}

	}

	// Return all employee details and also employee details of a specific
	// department
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<EmployeeResponse> getEmployeesDetails(
			@RequestParam(required = false, name = "department_name") String department) throws ParseException {

		final String uri = "https://restcountries.eu/rest/v2/alpha/ind";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(result);
		String setting_name = (String) json.get("name");
		

		if (department != null && !department.isEmpty()) {

			boolean departmentValidation = departmentRepository.existsByDepartmentNameIgnoreCase(department);
			if (!departmentValidation) {
				throw new MethodArgumentTypeMismatchException(null, null, department, null, null);
			}
			List<EmployeeResponse> response = employeeRepository
					.findByJobTitleDepartmentDepartmentNameIgnoreCase(department);
			if (response.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No Employees where found!!! Please provide a valid department");
			}

			return response;
		} else {
			return employeeRepository.findAllProjectedBy();
		}

	}

	// Return all active employee details
	@RequestMapping(value = "/employees/active", method = RequestMethod.GET)
	public List<EmployeeResponse> getActiveEmployees() {

		return employeeRepository.findByLeaveDateIsNull();
	}

	// Fetch country name from restcounties.eu api based on country code.
	public static String getCountryName(String countryCode) throws ParseException {
		final String uri = "https://restcountries.eu/rest/v2/alpha/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri + countryCode, String.class);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(result);
		String countryName = (String) json.get("name");
		return countryName;
	}

	// custom exception handling
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e,
			WebRequest request) {
		StringBuffer error = new StringBuffer();
		error.append(e.getName());
		if (error.toString().contains("badge_number")) {
			error.append(" contains non numerical character or invalid number");
		} else {
			error.append("-is not a valid department");
		}

		CustomError customError = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY, error.toString());
		return new ResponseEntity<Object>(customError, new HttpHeaders(), customError.getError());
	}
}