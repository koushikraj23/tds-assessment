package com.assessment.tds.dao;

import org.springframework.beans.factory.annotation.Value;

import com.assessment.tds.model.Department;

public interface JobResponse {
	
	String getJobTitleName();

	String getJobTitleCode();

	@Value("#{target.department.departmentName}")
	String getDepartmentName();

}
