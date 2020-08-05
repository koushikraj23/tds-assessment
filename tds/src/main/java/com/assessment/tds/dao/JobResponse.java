package com.assessment.tds.dao;

import org.springframework.beans.factory.annotation.Value;

//Interface to customize the response of Job title class(JPA projection)
public interface JobResponse {

	@Value("#{target.jobTitleName}")
	String getjob_title_name();

	@Value("#{target.jobTitleCode}")
	String getjob_title_code();

	@Value("#{target.department.departmentName}")
	String getdepartment_name();

}
