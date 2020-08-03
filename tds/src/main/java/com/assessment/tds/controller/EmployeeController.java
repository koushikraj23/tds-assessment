package com.assessment.tds.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.tds.repository.BadgeRepo;
import com.assessment.tds.repository.DepartmentRepo;
import com.assessment.tds.repository.EmployeeRepo;
import com.assessment.tds.repository.JobTitleRepo;
import com.assessment.tds.dao.JobResponse;
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

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@RequestMapping(value = "/staus", method = RequestMethod.GET)
	public List<Employee> getAvEmployees() {
		return employeeRepository.findByLeaveDateIsNull();
	}

	@RequestMapping(value = "/badges", method = RequestMethod.GET)
	public List<Badge> getBadgeDetails(@RequestParam(required = false, name = "badge_number") Long badgeNumber) {
		if (badgeNumber != null) {
			return badgeRepository.findByBadgeNo(badgeNumber);
		} else {
			return badgeRepository.findAll();
		}

	}

	@RequestMapping(value = "/badges/active", method = RequestMethod.GET)
	public List<Badge> getActiveBadges() {

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		return badgeRepository.findByBadgeStatusAndExpiryDateAfter("Active", date);
	}

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<Department> getAllDepartments() {

		return departmentRepository.findAll();
	}

	@RequestMapping(value = "/job_titles", method = RequestMethod.GET)
	public List<JobResponse> getAllJobTitles(
			@RequestParam(required = false, name = "department_name") String departmentName) {
		if (departmentName != null) {
			return jobTitleRepository.findByDepartmentDepartmentName(departmentName);
		} else {

			return jobTitleRepository.findAllProjectedBy();

		}

	}

	/*
	 * @RequestMapping(value = "/badges", method = RequestMethod.GET) public
	 * List<Badge> getBadgeByID(@RequestParam(required = false,name="badge_number")
	 * Long badge_number) {
	 * 
	 * 
	 * return badgeRepository.findByBadgeNo(badge_number); }
	 */
}