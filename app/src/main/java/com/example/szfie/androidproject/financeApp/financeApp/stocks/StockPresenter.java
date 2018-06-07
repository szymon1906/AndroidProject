package com.example.szfie.androidproject.financeApp.financeApp.stocks;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.example.szfie.androidproject.financeApp.financeApp.api.Api;
import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by szfie on 17.05.2018.
 */

public class StockPresenter implements StockContract.Presenter, LifecycleObserver{


    private Api api;
    private StockContract.View view;

    public StockPresenter(StockContract.View view, Api api){

        this.view= view;
        this.api = api;
        ((LifecycleOwner) this.view).getLifecycle().addObserver(this);

    }



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {getSymbols();}

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        getSymbols();
    }

    private void getSymbols() {
        api.getSymbols().enqueue(new Callback<List<Symbol>>() {
            @Override
            public void onResponse(Call<List<Symbol>> call, Response<List<Symbol>> response) {
                if (response.isSuccessful()) {
                    view.showData(response.body());
                } else {

                    view.showError();}}

            @Override
            public void onFailure(Call<List<Symbol> >call, Throwable t) {
               view.showError();}});}




    @Override
    public void onTryAgainClick() {
        getSymbols();
    }
}
