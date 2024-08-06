package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TopLosers extends DateAudit{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	
	private Long topLoserId;
	private String symbolCode;
	private String symbolDescription;
	private String marketCode;
	private Float prevClosingPrice;
	private Float openingPrice;
	private Float highPrice;
	private Float lowPrice;
	private Float currentPrice;
	private Float priceDiffToday;
	private Float percDiffToday;
	private Float topBidPrice;
	private Float topBidQuantity;
	private Float topOfferPrice;
	private Float topOfferQuantity;
	public Long getTopLoserId() {
		return topLoserId;
	}
	public void setTopLoserId(Long topLoserId) {
		this.topLoserId = topLoserId;
	}
	public String getSymbolCode() {
		return symbolCode;
	}
	public void setSymbolCode(String symbolCode) {
		this.symbolCode = symbolCode;
	}
	public String getSymbolDescription() {
		return symbolDescription;
	}
	public void setSymbolDescription(String symbolDescription) {
		this.symbolDescription = symbolDescription;
	}
	public String getMarketCode() {
		return marketCode;
	}
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	public Float getPrevClosingPrice() {
		return prevClosingPrice;
	}
	public void setPrevClosingPrice(Float prevClosingPrice) {
		this.prevClosingPrice = prevClosingPrice;
	}
	public Float getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(Float openingPrice) {
		this.openingPrice = openingPrice;
	}
	public Float getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Float highPrice) {
		this.highPrice = highPrice;
	}
	public Float getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Float lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Float getPriceDiffToday() {
		return priceDiffToday;
	}
	public void setPriceDiffToday(Float priceDiffToday) {
		this.priceDiffToday = priceDiffToday;
	}
	public Float getPercDiffToday() {
		return percDiffToday;
	}
	public void setPercDiffToday(Float percDiffToday) {
		this.percDiffToday = percDiffToday;
	}
	public Float getTopBidPrice() {
		return topBidPrice;
	}
	public void setTopBidPrice(Float topBidPrice) {
		this.topBidPrice = topBidPrice;
	}
	public Float getTopBidQuantity() {
		return topBidQuantity;
	}
	public void setTopBidQuantity(Float topBidQuantity) {
		this.topBidQuantity = topBidQuantity;
	}
	public Float getTopOfferPrice() {
		return topOfferPrice;
	}
	public void setTopOfferPrice(Float topOfferPrice) {
		this.topOfferPrice = topOfferPrice;
	}
	public Float getTopOfferQuantity() {
		return topOfferQuantity;
	}
	public void setTopOfferQuantity(Float topOfferQuantity) {
		this.topOfferQuantity = topOfferQuantity;
	}
	public TopLosers(Long topLoserId, String symbolCode, String symbolDescription, String marketCode,
			Float prevClosingPrice, Float openingPrice, Float highPrice, Float lowPrice, Float currentPrice,
			Float priceDiffToday, Float percDiffToday, Float topBidPrice, Float topBidQuantity, Float topOfferPrice,
			Float topOfferQuantity) {
		super();
		this.topLoserId = topLoserId;
		this.symbolCode = symbolCode;
		this.symbolDescription = symbolDescription;
		this.marketCode = marketCode;
		this.prevClosingPrice = prevClosingPrice;
		this.openingPrice = openingPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.currentPrice = currentPrice;
		this.priceDiffToday = priceDiffToday;
		this.percDiffToday = percDiffToday;
		this.topBidPrice = topBidPrice;
		this.topBidQuantity = topBidQuantity;
		this.topOfferPrice = topOfferPrice;
		this.topOfferQuantity = topOfferQuantity;
	}
	@Override
	public String toString() {
		return "TopLosers [topLoserId=" + topLoserId + ", symbolCode=" + symbolCode + ", symbolDescription="
				+ symbolDescription + ", marketCode=" + marketCode + ", prevClosingPrice=" + prevClosingPrice
				+ ", openingPrice=" + openingPrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice
				+ ", currentPrice=" + currentPrice + ", priceDiffToday=" + priceDiffToday + ", percDiffToday="
				+ percDiffToday + ", topBidPrice=" + topBidPrice + ", topBidQuantity=" + topBidQuantity
				+ ", topOfferPrice=" + topOfferPrice + ", topOfferQuantity=" + topOfferQuantity + "]";
	}
	
	
	public TopLosers() {
		super();
	}	

}
