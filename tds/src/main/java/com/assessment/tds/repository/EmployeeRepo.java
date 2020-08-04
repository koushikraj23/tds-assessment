package com.assessment.tds.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.tds.dao.BadgeResponse;
import com.assessment.tds.dao.EmployeeResponse;
import com.assessment.tds.dao.JobResponse;
import com.assessment.tds.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<EmployeeResponse> findAllProjectedBy();

	List<EmployeeResponse> findByLeaveDateIsNullOrLeaveDateAfter(Date date);
	List<EmployeeResponse> findByJobTitleDepartmentDepartmentName(String a);

}