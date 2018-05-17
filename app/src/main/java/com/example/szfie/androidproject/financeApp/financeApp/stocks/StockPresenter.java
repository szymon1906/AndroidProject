package com.example.szfie.androidproject.financeApp.financeApp.stocks;

/**
 * Created by szfie on 17.05.2018.
 */

public class StockPresenter implements StockContract.Presenter{


    private StockContract.View view;

    public StockPresenter(StockContract.View view){

        this.view= view;
    }
}
