package com.spearhead.nova.model.pojoClasses;

public class GetFund {
  

          private String FUND_ID;
          private String FUND_DESCRIPTION;
      
          private String FUND_CURRENCY;
          private String FUND_TYPE;
          private String DATE_OPENED;

        public String getFUND_ID() {
            return FUND_ID;
        }
        public void setFUND_ID(String fUND_ID) {
            FUND_ID = fUND_ID;
        }
        public String getFUND_DESCRIPTION() {
            return FUND_DESCRIPTION;
        }
        public void setFUND_DESCRIPTION(String fUND_DESCRIPTION) {
            FUND_DESCRIPTION = fUND_DESCRIPTION;
        }
        public String getFUND_CURRENCY() {
            return FUND_CURRENCY;
        }
        public void setFUND_CURRENCY(String fUND_CURRENCY) {
            FUND_CURRENCY = fUND_CURRENCY;
        }
        public String getFUND_TYPE() {
            return FUND_TYPE;
        }
        public void setFUND_TYPE(String fUND_TYPE) {
            FUND_TYPE = fUND_TYPE;
        }
        public String getDATE_OPENED() {
            return DATE_OPENED;
        }
        public void setDATE_OPENED(String dATE_OPENED) {
            DATE_OPENED = dATE_OPENED;
        }
     
        
        public GetFund(String fUND_ID, String fUND_DESCRIPTION, String fUND_CURRENCY, String fUND_TYPE,
                String dATE_OPENED) {
            FUND_ID = fUND_ID;
            FUND_DESCRIPTION = fUND_DESCRIPTION;
            FUND_CURRENCY = fUND_CURRENCY;
            FUND_TYPE = fUND_TYPE;
            DATE_OPENED = dATE_OPENED;
        }
       

        @Override
        public String toString() {
            return "{\"DATE_OPENED\":\"" + DATE_OPENED + "\",\"FUND_CURRENCY\":\"" + FUND_CURRENCY
                    + "\",\"FUND_DESCRIPTION\":\"" + FUND_DESCRIPTION + "\",\"FUND_ID\":\""
                    + FUND_ID + "\",  \"FUND_TYPE\":\""
                    + FUND_TYPE + "\"}";
    
        }
        

        

          
     
}
