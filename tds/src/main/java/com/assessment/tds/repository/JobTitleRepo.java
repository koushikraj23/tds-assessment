package com.assessment.tds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.tds.dao.JobResponse;
import com.assessment.tds.model.JobTitle;

@Repository
public interface JobTitleRepo extends JpaRepository<JobTitle, Long> {
	List<JobResponse> findAllProjectedBy();

	List<JobResponse> findByDepartmentDepartmentName(String a);
}
