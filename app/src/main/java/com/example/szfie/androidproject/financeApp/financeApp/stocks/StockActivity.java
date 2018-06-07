package com.example.szfie.androidproject.financeApp.financeApp.stocks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.example.szfie.androidproject.R;
import com.example.szfie.androidproject.financeApp.financeApp.api.Api;
import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;
import com.google.gson.Gson;

import java.security.acl.Group;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class StockActivity extends AppCompatActivity implements StockContract.View {



    private StockContract.Presenter presenter;
    private StockAdapter stockAdapter;

    @BindView(R.id.symbol_reycler)
    RecyclerView stockRecycler;

    @BindView(R.id.symbol_progress)
    ProgressBar symbolProgess;

    @OnClick(R.id.symbol_button)

    public void onTryAgainClick() {

        presenter.onTryAgainClick();

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.Base_URL).addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        presenter = new StockPresenter(this, retrofit.create(Api.class));

        stockAdapter = new StockAdapter();
        stockRecycler.setLayoutManager(new LinearLayoutManager(this));
        stockRecycler.setAdapter(stockAdapter);

    }


    @Override
    public void showError() {

    }

    @Override
    public void showData(List<Symbol> symbols) {

        symbolProgess.setVisibility(View.INVISIBLE);
        stockRecycler.setVisibility(View.VISIBLE);
        stockAdapter.updateSymbols(symbols);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
