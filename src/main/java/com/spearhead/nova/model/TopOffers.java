package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TopOffers extends DateAudit {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long topOfferId;
	private String symbolCode;
	private Float orderCount;
	private Float quantOnOffer;
	private String offerPrice;
	public Long getTopOfferId() {
		return topOfferId;
	}
	public void setTopOfferId(Long topOfferId) {
		this.topOfferId = topOfferId;
	}
	public String getSymbolCode() {
		return symbolCode;
	}
	public void setSymbolCode(String symbolCode) {
		this.symbolCode = symbolCode;
	}
	public Float getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Float orderCount) {
		this.orderCount = orderCount;
	}
	public Float getQuantOnOffer() {
		return quantOnOffer;
	}
	public void setQuantOnOffer(Float quantOnOffer) {
		this.quantOnOffer = quantOnOffer;
	}
	public String getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}
	
	
	public TopOffers() {
		super();
	}
	
	public TopOffers(Long topOfferId, String symbolCode, Float orderCount, Float quantOnOffer, String offerPrice) {
		super();
		this.topOfferId = topOfferId;
		this.symbolCode = symbolCode;
		this.orderCount = orderCount;
		this.quantOnOffer = quantOnOffer;
		this.offerPrice = offerPrice;
	}
	@Override
	public String toString() {
		return "TopOffers [topOfferId=" + topOfferId + ", symbolCode=" + symbolCode + ", orderCount=" + orderCount
				+ ", quantOnOffer=" + quantOnOffer + ", offerPrice=" + offerPrice + "]";
	}
	
		
	
}
