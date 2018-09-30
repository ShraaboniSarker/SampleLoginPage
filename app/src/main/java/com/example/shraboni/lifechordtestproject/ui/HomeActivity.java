package com.example.shraboni.lifechordtestproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shraboni.lifechordtestproject.R;

public class HomeActivity extends AppCompatActivity {

    Button btRecharge;
    Button btHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btRecharge = findViewById(R.id.btRecharge);
        btHistory = findViewById(R.id.btHistory);

        btRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });

        btHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,HistoryActivity.class));
            }
        });

    }
}
