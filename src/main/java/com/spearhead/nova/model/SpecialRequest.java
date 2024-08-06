package com.spearhead.nova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SpecialRequest  extends DateAudit{
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(generator = "audit_user_generator")
    @SequenceGenerator(
   		name = "audit_user_generator",
   		sequenceName = "audit_user_sequence",
   		initialValue = 100
   		)

           private Long specialRequestId;
           @Column(name="specialRequest", length=512, nullable = false)
         
           private String specialRequest;
           private String customerId;
		public Long getSpecialRequestId() {
			return specialRequestId;
		}
		public void setSpecialRequestId(Long specialRequestId) {
			this.specialRequestId = specialRequestId;
		}
		public String getSpecialRequest() {
			return specialRequest;
		}
		public void setSpecialRequest(String specialRequest) {
			this.specialRequest = specialRequest;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public SpecialRequest(Long specialRequestId, String specialRequest, String customerId) {
			this.specialRequestId = specialRequestId;
			this.specialRequest = specialRequest;
			this.customerId = customerId;
		}
		@Override
		public String toString() {
			return "SpecialRequest [customerId=" + customerId + ", specialRequest=" + specialRequest
					+ ", specialRequestId=" + specialRequestId + "]";
		}
		public SpecialRequest() {
            super();
		}





        
    
}
