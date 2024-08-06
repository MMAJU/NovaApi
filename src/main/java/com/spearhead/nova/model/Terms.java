package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terms extends DateAudit{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)
	
	private Long termsId;
	
	@Column(name="terms", length=512, nullable = false)
	private String terms;
	public Long getTermsId() {
		return termsId;
	}
	public void setTermsId(Long termsId) {
		this.termsId = termsId;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	
	@Override
	public String toString() {
		return "Terms [termsId=" + termsId + ", terms=" + terms + "]";
	}
	public Terms(Long termsId, String terms) {
		super();
		this.termsId = termsId;
		this.terms = terms;
	}
	
	public Terms() {
		super();
	}


}
