package com.fahad.zongpackages;

public class product {

    String ACTIVATION;
    String DEACTIVATION;
    String VOLUME;
    String DURATION;
    String INFO;
    String PRICE;
    String REMAINING;
    String TITLE;

    public product(String ACTIVATION, String DEACTIVATION, String DURATION, String INFO,  String PRICE, String REMAINING, String TITLE, String VOLUME) {
        this.ACTIVATION = ACTIVATION;
        this.DEACTIVATION = DEACTIVATION;
        this.VOLUME = VOLUME;
        this.DURATION = DURATION;
        this.INFO = INFO;
        this.PRICE = PRICE;
        this.REMAINING = REMAINING;
        this.TITLE = TITLE;
    }

    public String getACTIVATION() {
        return ACTIVATION;
    }

    public String getDEACTIVATION() {
        return DEACTIVATION;
    }

    public String getVOLUME() {
        return VOLUME;
    }

    public String getDURATION() {
        return DURATION;
    }

    public String getINFO() {
        return INFO;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getREMAINING() {
        return REMAINING;
    }

    public String getTITLE() {
        return TITLE;
    }

    public product() {
    }
}


