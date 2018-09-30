package com.example.shraboni.lifechordtestproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shraboni.lifechordtestproject.R;
import com.example.shraboni.lifechordtestproject.adapter.CardMessageAdapter;
import com.example.shraboni.lifechordtestproject.data.CardHistorySource;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvCardMessages;
    CardMessageAdapter adapter;
    CardHistorySource source;
    ArrayList<String> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvCardMessages = findViewById(R.id.rvCardMessages);

        source=new CardHistorySource(this);
        messages = source.getAllLMessage();
        if(!messages.isEmpty())
            adapterAttached(messages);

    }
    public void adapterAttached(ArrayList<String> listing){

        adapter = new CardMessageAdapter(getApplicationContext(),listing);
        rvCardMessages.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //activityIndicator.setVisibility(View.GONE);
        LinearLayoutManager recyce = new LinearLayoutManager(HistoryActivity.this);
        rvCardMessages.setHasFixedSize(false);
        rvCardMessages.setLayoutManager(recyce);
    }
}
