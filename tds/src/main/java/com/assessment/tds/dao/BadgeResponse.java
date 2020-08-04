package com.assessment.tds.dao;

import org.springframework.beans.factory.annotation.Value;

public interface BadgeResponse {

	@Value("#{target.badgeNo}")
	String getbadge_code();

	@Value("#{target.badgeStatus}")
	String getbadge_status();
	
	@Value("#{target.expiryDate}")
	String getbadge_expiry_date();
}
