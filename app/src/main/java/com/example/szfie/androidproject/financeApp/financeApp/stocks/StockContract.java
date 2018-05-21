package com.example.szfie.androidproject.financeApp.financeApp.stocks;

import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;

import java.util.List;

/**
 * Created by szfie on 17.05.2018.
 */

public interface StockContract {

    interface View {

        void showError();

        void showData(List<Symbol> symbolList);
    }

    interface Presenter {


        void onTryAgainClick();

    }
}
