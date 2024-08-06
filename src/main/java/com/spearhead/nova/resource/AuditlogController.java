package com.spearhead.nova.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spearhead.nova.model.AuditLogs;
import com.spearhead.nova.service.AuditlogService;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints",tags={"Audit Log"}, description = "Rest APIs that Returns Information Corncering the Customer Action")

@RestController
@RequestMapping("/api/customer/audit")
public class AuditlogController {
	
	@Autowired
	private AuditlogService auditlogService;

	 @GetMapping("/details")
	 public List<AuditLogs> fetchAuditlogList(){
		return auditlogService.fetchAuditlogList();
		 
	 }
	 
	 
}
