package com.assessment.tds.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.parser.ParseException;
import com.assessment.tds.controller.EmployeeController;
import com.assessment.tds.model.JobTitle;

//Class to customize response of employee class details

public class EmployeeResponse {

	static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String firstName;
	private String lastName;
	private String country;
	private int badge_number;
	private String job_title;
	private String department;
	private String start_date;
	private String leave_date;

	public EmployeeResponse(int id, int badgeNo, String firstName, String lastName, String countryCode,
			JobTitle jobTitle, Date startDate, Date leaveDate) {
		super();
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = countryCode;
		this.badge_number = badgeNo;
		this.job_title = jobTitle.getJobTitleName();
		this.department = jobTitle.getDepartment().getDepartmentName();
		this.start_date = DATE_FORMAT.format(startDate);
		this.leave_date = leaveDate != null ? DATE_FORMAT.format(leaveDate) : null;

		try {
			this.country = EmployeeController.getCountryName(countryCode);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBadge_number() {
		return badge_number;
	}

	public void setBadge_number(int badge_number) {
		this.badge_number = badge_number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(String leave_date) {
		this.leave_date = leave_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
