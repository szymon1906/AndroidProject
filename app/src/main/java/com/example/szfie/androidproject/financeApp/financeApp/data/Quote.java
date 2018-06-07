package com.example.szfie.androidproject.financeApp.financeApp.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by szfie on 18.05.2018.
 */

public class Quote {

        private String symbol;
     private String name;
     private String companyName;
    private String PrimaryExchange;
    private String Technology;
    private String latestPrice;


    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrimaryExchange() {
        return PrimaryExchange;
    }

    public String getTechnology() {
        return Technology;
    }

    public String getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
    }

    public void setCompanyName(String companyName) {
        companyName = companyName;
    }

    public void setPrimaryExchange(String primaryExchange) {
        PrimaryExchange = primaryExchange;
    }

    public void setTechnology(String technology) {
        Technology = technology;
    }
}
