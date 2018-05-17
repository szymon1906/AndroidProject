package com.example.szfie.androidproject.financeApp.financeApp.stocks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.szfie.androidproject.R;

import butterknife.ButterKnife;


public class StockActivity extends AppCompatActivity implements StockContract.View{

        private StockContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        ButterKnife.bind(this);
        presenter = new StockPresenter(this);

    }
}
