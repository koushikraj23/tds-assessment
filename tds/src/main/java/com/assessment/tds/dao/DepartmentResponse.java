package com.assessment.tds.dao;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentResponse {

	@Value("#{target.departmentCode}")
	String getdepartment_code();

	@Value("#{target.departmentName}")
	String getdepartment_name();
}
