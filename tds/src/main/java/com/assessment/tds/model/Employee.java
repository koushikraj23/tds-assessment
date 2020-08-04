package com.assessment.tds.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")

public class Employee {
	@Id
	private int id;
	@Column(name = "badge_number")
	private int badgeNo;
//	@Column(name = "job_title_code")
//	private int jobtitleCode;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "start_Date")
	private Date startDate;
	@Column(name = "leave_date")
	private Date leaveDate;

	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "job_title_code",nullable = false )
	@JsonIgnore
	private JobTitle jobTitle;

	
	
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

//	public int getJobtitleCode() {
//		return jobtitleCode;
//	}
//
//	public void setJobtitleCode(int jobtitleCode) {
//		this.jobtitleCode = jobtitleCode;
//	}

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}



}
