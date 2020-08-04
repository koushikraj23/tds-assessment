package com.assessment.tds.dao;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeResponse {

	@Value("#{target.id}")
	String getid();
	
	@Value("#{target.firstName}")
	String getfirstname();

	@Value("#{target.lastName}")
	String getlastname();

	@Value("#{target.badgeNo}")
	String getbadge_number();

	@Value("#{target.countryCode}")
	String getcountry_code();
	
	@Value("#{target.jobTitle.jobTitleName}")
	String getjob_title();
	@Value("#{target.jobTitle.department.departmentName}")
	String getdepartment();
	@Value("#{target.startDate}")
	String getstart_date();

	@Value("#{target.leaveDate}")
	String getleave_date();

}
