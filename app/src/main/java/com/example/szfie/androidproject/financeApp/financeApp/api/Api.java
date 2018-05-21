package com.example.szfie.androidproject.financeApp.financeApp.api;

import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by szfie on 17.05.2018.
 */

public interface Api {

    String Base_URL ="https://api.iextrading.com/1.0/ref-data/";


    @GET("symbols")
    Call<List<Symbol>> getSymbols();
}
