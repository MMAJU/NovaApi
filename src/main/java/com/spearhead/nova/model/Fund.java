package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Fund extends DateAudit {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long fundId;
	private String fundDescription;
	private String fundCurrency;
	private String fundType;
	private String dateOpened;
	private Float minimumInvestmentAmount;
	private Float subsequentMultiples;
	private Float offerPrice;
	private Float bidPrice;
	private Float isMoneyMarket;
	private String investmestBasis;
	private Float principalAmount;
	private Float accruedAmount;
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public String getFundDescription() {
		return fundDescription;
	}
	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}
	public String getFundCurrency() {
		return fundCurrency;
	}
	public void setFundCurrency(String fundCurrency) {
		this.fundCurrency = fundCurrency;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public Float getMinimumInvestmentAmount() {
		return minimumInvestmentAmount;
	}
	public void setMinimumInvestmentAmount(Float minimumInvestmentAmount) {
		this.minimumInvestmentAmount = minimumInvestmentAmount;
	}
	public Float getSubsequentMultiples() {
		return subsequentMultiples;
	}
	public void setSubsequentMultiples(Float subsequentMultiples) {
		this.subsequentMultiples = subsequentMultiples;
	}
	public Float getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Float offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Float getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Float bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Float getIsMoneyMarket() {
		return isMoneyMarket;
	}
	public void setIsMoneyMarket(Float isMoneyMarket) {
		this.isMoneyMarket = isMoneyMarket;
	}
	public String getInvestmestBasis() {
		return investmestBasis;
	}
	public void setInvestmestBasis(String investmestBasis) {
		this.investmestBasis = investmestBasis;
	}
	
	
	
	
	public Float getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(Float principalAmount) {
		this.principalAmount = principalAmount;
	}
	public Float getAccruedAmount() {
		return accruedAmount;
	}
	public void setAccruedAmount(Float accruedAmount) {
		this.accruedAmount = accruedAmount;
	}
	public Fund(Long fundId, String fundDescription, String fundCurrency, String fundType, String dateOpened,
			Float minimumInvestmentAmount, Float subsequentMultiples, Float offerPrice, Float bidPrice,
			Float isMoneyMarket, String investmestBasis,Float principalAmount, Float accruedAmount) {
		super();
		this.fundId = fundId;
		this.fundDescription = fundDescription;
		this.fundCurrency = fundCurrency;
		this.fundType = fundType;
		this.dateOpened = dateOpened;
		this.minimumInvestmentAmount = minimumInvestmentAmount;
		this.subsequentMultiples = subsequentMultiples;
		this.offerPrice = offerPrice;
		this.bidPrice = bidPrice;
		this.isMoneyMarket = isMoneyMarket;
		this.investmestBasis = investmestBasis;

		this.principalAmount = principalAmount;
		this.accruedAmount = accruedAmount;
	}

	
	
	@Override
	public String toString() {
		return "Fund [accruedAmount=" + accruedAmount + ", bidPrice=" + bidPrice + ", dateOpened=" + dateOpened
				+ ", fundCurrency=" + fundCurrency + ", fundDescription=" + fundDescription + ", fundId=" + fundId
				+ ", fundType=" + fundType + ", investmestBasis=" + investmestBasis + ", isMoneyMarket=" + isMoneyMarket
				+ ", minimumInvestmentAmount=" + minimumInvestmentAmount + ", offerPrice=" + offerPrice
				+ ", principalAmount=" + principalAmount + ", subsequentMultiples=" + subsequentMultiples + "]";
	}
	public Fund() {
		super();
	}	

}
