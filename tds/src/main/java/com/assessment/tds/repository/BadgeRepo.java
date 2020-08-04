package com.assessment.tds.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.tds.dao.BadgeResponse;
import com.assessment.tds.model.Badge;
import com.assessment.tds.model.Employee;
@Repository
public interface BadgeRepo extends JpaRepository<Badge, Long> {
	List<BadgeResponse> findAllProjectedBy();
	List<BadgeResponse> findByBadgeStatusAndExpiryDateAfter(String status,Date date);
	List<BadgeResponse> findByBadgeNo(long badge_number);
}
