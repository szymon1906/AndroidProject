package com.example.szfie.androidproject.financeApp.financeApp.quote;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.szfie.androidproject.R;
import com.example.szfie.androidproject.financeApp.financeApp.api.Api;
import com.example.szfie.androidproject.financeApp.financeApp.data.Quote;
import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;
import com.example.szfie.androidproject.financeApp.financeApp.stocks.StockAdapter;
import com.example.szfie.androidproject.financeApp.financeApp.stocks.StockPresenter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;

/**
 * Created by szfie on 22.05.2018.
 */

public class Quotectivity extends AppCompatActivity {



    public static final String KEY_STOCK_SYMBOL ="symbol";

    @BindView(R.id.item_quote_symbol)
    TextView quoteSymbol;

    @BindView(R.id.item_name)
    TextView name;

    @BindView(R.id.item_company_name)
    TextView companyName;

    @BindView(R.id.item_latest_price)
    TextView latestPrice;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        ButterKnife.bind(this);

       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Quote_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                 Api api = retrofit.create(Api.class);
                 Intent intent = getIntent();
                 String symbolQuote = intent.getStringExtra(KEY_STOCK_SYMBOL);
                Log.d("testtest", symbolQuote);



           Call <Quote> call = api.getQuotes(symbolQuote);

            call.enqueue(new Callback<Quote>() {
           @Override
           public void onResponse(Call<Quote> call, Response<Quote> response) {

               if (response.isSuccessful()) {
                    Log.d("Testtest",response.body().toString());

                   Quote quote = response.body();
                   quoteSymbol.setText(quote.getSymbol());
                   name.setText(quote.getName());
                   companyName.setText(quote.getCompanyName());
                   latestPrice.setText(quote.getLatestPrice());
               }

               else
                  
                   try {
                       JSONObject jObjError = new JSONObject(response.errorBody().string());
                       verifyResponse(response.errorBody().string());
                   } catch (Exception e) {
                        e.printStackTrace();
                   }

           }


           @Override
           public void onFailure(Call<Quote> call, Throwable t) {
               Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();
           }
       });


    }

    private void verifyResponse(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }


}



