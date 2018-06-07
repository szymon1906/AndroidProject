package com.example.szfie.androidproject.financeApp.financeApp.api;

import com.example.szfie.androidproject.financeApp.financeApp.data.Quote;
import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by szfie on 17.05.2018.
 */

public interface Api {

    String Base_URL ="https://api.iextrading.com/1.0/ref-data/";

    String Quote_URL = "https://api.iextrading.com/1.0/";


    @GET("symbols")
    Call<List<Symbol>> getSymbols();

    @GET("stock/{symbol}/quote")
    Call <Quote> getQuotes(@Path("symbol") String symbol);

}
