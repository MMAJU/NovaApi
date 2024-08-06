package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AuditLogs extends DateAudit {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)
	private Long autologId;


	
	private Integer user_id;
	
	@Column(name="action", length=512, nullable = false)
	private String action;
	
	private String status;
	
	public AuditLogs() {
		super();
	}
	
	public AuditLogs(Long autologId, Integer user_id, String action, String status) {
		super();
	
		this.user_id = user_id;
		this.action = action;
		this.status = status;
	}
	
	public Long getAutologId() {
		return autologId;
	}
	public void setAutologId(Long autologId) {
		this.autologId = autologId;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "AuditLogs [autologId=" + autologId + ", user_id=" + user_id + ", action=" + action + ", status="
				+ status + "]";
	}
}
