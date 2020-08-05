package com.assessment.tds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "job_title")
public class JobTitle {

	@Id
	@Column(name = "job_title_code")
	private int jobTitleCode;

	@Column(name = "job_title_name")
	private String jobTitleName;
	
	//represent relationship between two tables
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "department_code", nullable = false)
	@JsonIgnore
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobTitle(Department department, int jobTitleCode, String jobTitleName) {
		super();
		this.department = department;
		this.jobTitleCode = jobTitleCode;
		this.jobTitleName = jobTitleName;
	}

	public int getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(int jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}


}
