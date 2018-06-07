package com.example.szfie.androidproject.financeApp.financeApp.stocks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.szfie.androidproject.R;
import com.example.szfie.androidproject.financeApp.financeApp.data.Symbol;
import com.example.szfie.androidproject.financeApp.financeApp.quote.Quotectivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by szfie on 17.05.2018.
 */

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder>  {

    private List<Symbol> symbolList = new ArrayList<>();



    public void updateSymbols(List<Symbol> symbol){
        symbolList.clear();
        symbolList.addAll(symbol);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_symbol,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.setSymbol(symbolList.get(position));
    }

    @Override
    public int getItemCount() {
        return symbolList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{



        @BindView(R.id.item_company_name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);}

        public void setSymbol(final Symbol symbol2) {

            name.setText(symbol2.getName());


            itemView.setOnClickListener(view->{
                   Intent intent = new Intent(itemView.getContext(),Quotectivity.class);
                    intent.putExtra(Quotectivity.KEY_STOCK_SYMBOL, symbol2.getSymbol());
                    itemView.getContext().startActivity(intent);});

    }
    }


}


