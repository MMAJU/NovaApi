package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FundPrice extends DateAudit{
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
    private Long fundPriceId;
    private String fundDescription;
	private String valueDate;
	private String bidPrice;
	private String offerDate;
    public Long getFundPriceId() {
        return fundPriceId;
    }
    public void setFundPriceId(Long fundPriceId) {
        this.fundPriceId = fundPriceId;
    }
    public String getFundDescription() {
        return fundDescription;
    }
    public void setFundDescription(String fundDescription) {
        this.fundDescription = fundDescription;
    }
    public String getValueDate() {
        return valueDate;
    }
    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }
    public String getBidPrice() {
        return bidPrice;
    }
    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }
    public String getOfferDate() {
        return offerDate;
    }
    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }
    public FundPrice(Long fundPriceId, String fundDescription, String valueDate, String bidPrice, String offerDate) {
        this.fundPriceId = fundPriceId;
        this.fundDescription = fundDescription;
        this.valueDate = valueDate;
        this.bidPrice = bidPrice;
        this.offerDate = offerDate;
    }
    @Override
    public String toString() {
        return "FundPrice [bidPrice=" + bidPrice + ", fundDescription=" + fundDescription + ", fundPriceId="
                + fundPriceId + ", offerDate=" + offerDate + ", valueDate=" + valueDate + "]";
    }

    public FundPrice() {
		super();
	}	
    
	
}
