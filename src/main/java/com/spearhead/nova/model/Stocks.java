package com.spearhead.nova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Stocks extends DateAudit  {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)

           private Long stocksId;
           private String marketId;
           private String marketDescription;
           private String symbolId;
           private String symbolDescription;
           private String openingPrice;
           private String registratDescription;
           private String symbolType;
           private float  marketPercentage;
           
        public Long getStocksId() {
            return stocksId;
        }
        public void setStocksId(Long stocksId) {
            this.stocksId = stocksId;
        }
        public String getMarketId() {
            return marketId;
        }
        public void setMarketId(String marketId) {
            this.marketId = marketId;
        }
        public String getMarketDescription() {
            return marketDescription;
        }
        public void setMarketDescription(String marketDescription) {
            this.marketDescription = marketDescription;
        }
        public String getSymbolId() {
            return symbolId;
        }
        public void setSymbolId(String symbolId) {
            this.symbolId = symbolId;
        }
        public String getSymbolDescription() {
            return symbolDescription;
        }
        public void setSymbolDescription(String symbolDescription) {
            this.symbolDescription = symbolDescription;
        }
        public String getOpeningPrice() {
            return openingPrice;
        }
        public void setOpeningPrice(String openingPrice) {
            this.openingPrice = openingPrice;
        }
        public String getRegistratDescription() {
            return registratDescription;
        }
        public void setRegistratDescription(String registratDescription) {
            this.registratDescription = registratDescription;
        }
        public String getSymbolType() {
            return symbolType;
        }
        public void setSymbolType(String symbolType) {
            this.symbolType = symbolType;
        }

        

        public float getMarketPercentage() {
            return marketPercentage;
        }
        public void setMarketPercentage(float marketPercentage) {
            this.marketPercentage = marketPercentage;
        }
       
        


        @Override
        public String toString() {
            return "Stocks [marketDescription=" + marketDescription + ", marketId=" + marketId + ", marketPercentage="
                    + marketPercentage + ", openingPrice=" + openingPrice + ", registratDescription="
                    + registratDescription + ", stocksId=" + stocksId + ", symbolDescription=" + symbolDescription
                    + ", symbolId=" + symbolId + ", symbolType=" + symbolType + "]";
        }
        public Stocks() {
            super();
        }

        


}
