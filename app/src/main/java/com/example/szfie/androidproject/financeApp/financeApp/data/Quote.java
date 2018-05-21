package com.example.szfie.androidproject.financeApp.financeApp.data;

/**
 * Created by szfie on 18.05.2018.
 */

public class Quote {


     public String name;
     public String CompanyName;
    public String PrimaryExchange;
    public String Technology;
    public int latestPrice;

    public String getCompanyName() {
        return CompanyName;
    }

    public String getPrimaryExchange() {
        return PrimaryExchange;
    }

    public String getTechnology() {
        return Technology;
    }

    public int getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(int latestPrice) {
        this.latestPrice = latestPrice;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setPrimaryExchange(String primaryExchange) {
        PrimaryExchange = primaryExchange;
    }

    public void setTechnology(String technology) {
        Technology = technology;
    }
}
