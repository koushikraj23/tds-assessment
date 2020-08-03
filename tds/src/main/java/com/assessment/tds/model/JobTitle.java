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

	@Id
	@Column(name = "job_title_code")
	private int jobTitleCode;
	/*
	 * @Column(name = "department_code") private int departmentCode;
	 */
	@Column(name = "job_title_name")
	private String jobTitleName;

	public JobTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobTitle(Department department, int jobTitleCode, int departmentCode, String jobTitleName) {
		super();
		this.department = department;
		this.jobTitleCode = jobTitleCode;
//		this.departmentCode = departmentCode;
		this.jobTitleName = jobTitleName;
	}

	public int getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(int jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

//	public int getDepartmentCode() {
//		return departmentCode;
//	}
//
//	public void setDepartmentCode(int departmentCode) {
//		this.departmentCode = departmentCode;
//	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("First name : ").append(this.jobTitleName).append("\n");
		sb.append("Last name : ").append(this.jobTitleName).append("\n");
		sb.append("Email : ").append(this.jobTitleName).append("\n");
		return sb.toString();
	}
}
