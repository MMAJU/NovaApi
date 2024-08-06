package com.spearhead.nova.service;

import java.time.LocalDateTime;
//import java.util.Date;
import java.util.List;



import com.spearhead.nova.model.AuditLogs;



public interface AuditlogService {
	

 
	public AuditLogs saveAuditlog(AuditLogs auditlogs);
	public List<AuditLogs> fetchAuditlogList();
	//public List<AuditLogs> getAllBetweenDates(Date startDate, Date endDate);
	public List<AuditLogs> getAllBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
	

	



}
