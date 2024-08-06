package com.spearhead.nova.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.AuditLogs;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.service.AuditlogService;

@Service
public class AuditlogImpl implements AuditlogService {

	@Autowired
	private AuditlogRepository auditlogRepository;
	
	@Override
	public List<AuditLogs> fetchAuditlogList() {
		// TODO Auto-generated method stub
		return auditlogRepository.findAll();
	}

	@Override
	public AuditLogs saveAuditlog(AuditLogs auditlogs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditLogs> getAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
