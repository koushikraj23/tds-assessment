package com.assessment.tds.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "badge")

public class Badge {
	@Id
	@Column(name = "badge_number")
	private long badgeNo;
	@Column(name="badge_status")
	private String badgeStatus;
	@Column(name="badge_expiry_date")
	private Date expiryDate;
	public Badge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Badge(int badgeNo, String badgeStatus, Date expiryDate) {
		super();
		this.badgeNo = badgeNo;
		this.badgeStatus = badgeStatus;
		this.expiryDate = expiryDate;
	}
	public long getBadgeNo() {
		return  badgeNo;
	}
	public void setBadgeNo(int badgeNo) {
		this.badgeNo = badgeNo;
	}
	public String getBadgeStatus() {
		return badgeStatus;
	}
	public void setBadgeStatus(String badgeStatus) {
		this.badgeStatus = badgeStatus;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
