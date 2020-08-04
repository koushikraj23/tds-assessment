package com.assessment.tds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.tds.dao.DepartmentResponse;
import com.assessment.tds.model.Department;
import com.assessment.tds.model.Employee;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

	List<DepartmentResponse> findAllProjectedBy();
	boolean existsByDepartmentName(String department);
}
