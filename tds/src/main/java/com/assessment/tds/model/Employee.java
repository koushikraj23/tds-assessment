package com.assessment.tds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")

public class Employee {
	@Id
	private int id;
	@Column(name = "badge_number")
	private int badgeNo;
	@Column(name = "job_title_code")
	private int jobtitleCode;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "start_Date")
	private String startDate;
	@Column(name = "leave_date")
	private String leaveDate;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getBadgeNo() {
		return badgeNo;
	}

	public void setBadgeNo(int badgeNo) {
		this.badgeNo = badgeNo;
	}


	public int getJobtitleCode() {
		return jobtitleCode;
	}

	public void setJobtitleCode(int jobtitleCode) {
		this.jobtitleCode = jobtitleCode;
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

	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

}
