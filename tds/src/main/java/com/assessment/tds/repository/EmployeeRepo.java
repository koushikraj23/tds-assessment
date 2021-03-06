package com.assessment.tds.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assessment.tds.dao.EmployeeResponse;
import com.assessment.tds.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<EmployeeResponse> findAllProjectedBy();

	List<EmployeeResponse> findByLeaveDateIsNull();

	List<EmployeeResponse> findByJobTitleDepartmentDepartmentNameIgnoreCase(String a);

}