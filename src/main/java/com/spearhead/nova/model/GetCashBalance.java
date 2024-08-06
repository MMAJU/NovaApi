package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class GetCashBalance  extends DateAudit{

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
           private Long getCashBalanceAccountId;
          
           private String customerId;
           private String availableBalance;
           private String currentBalance;
        public Long getGetCashBalanceAccountId() {
            return getCashBalanceAccountId;
        }
        public void setGetCashBalanceAccountId(Long getCashBalanceAccountId) {
            this.getCashBalanceAccountId = getCashBalanceAccountId;
        }
        public String getCustomerId() {
            return customerId;
        }
        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }
        public String getAvailableBalance() {
            return availableBalance;
        }
        public void setAvailableBalance(String availableBalance) {
            this.availableBalance = availableBalance;
        }
        public String getCurrentBalance() {
            return currentBalance;
        }
        public void setCurrentBalance(String currentBalance) {
            this.currentBalance = currentBalance;
        }
        public GetCashBalance(Long getCashBalanceAccountId, String customerId, String availableBalance,
                String currentBalance) {
            this.getCashBalanceAccountId = getCashBalanceAccountId;
            this.customerId = customerId;
            this.availableBalance = availableBalance;
            this.currentBalance = currentBalance;
        }
        @Override
        public String toString() {
            return "GetCashBalance [availableBalance=" + availableBalance + ", currentBalance=" + currentBalance
                    + ", customerId=" + customerId + ", getCashBalanceAccountId=" + getCashBalanceAccountId + "]";
        }
        public GetCashBalance() {
            super();
        }
    
            

}
