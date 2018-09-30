package com.example.shraboni.lifechordtestproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shraboni.lifechordtestproject.R;

import java.util.ArrayList;

public class CardMessageAdapter extends RecyclerView.Adapter<CardMessageAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> listing;

    public CardMessageAdapter(Context context, ArrayList<String> listing) {
        this.context = context;
        this.listing = listing;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tvMessage.setText(listing.get(i));

    }

    @Override
    public int getItemCount() {
        return listing.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvMessage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
        }
    }
}
