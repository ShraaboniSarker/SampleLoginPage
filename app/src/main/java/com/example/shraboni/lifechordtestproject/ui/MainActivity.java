package com.example.shraboni.lifechordtestproject.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shraboni.lifechordtestproject.R;
import com.example.shraboni.lifechordtestproject.data.CardHistorySource;
import com.example.shraboni.lifechordtestproject.model.CardRechargeResponseApiError;
import com.example.shraboni.lifechordtestproject.network.APIService;
import com.example.shraboni.lifechordtestproject.network.RetrofitClientInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //@BindView(R.id.etCardPin)
    EditText card_pin;
    //@BindView(R.id.etCardMobile)
    EditText card_mobile;
    //@BindView(R.id.btSubmit)
    Button btSubmit;
    APIService apiService;
    String cardPinNo;
    String mobileNo;
    CardHistorySource cardHistorySource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btSubmit = findViewById(R.id.btSubmit);
        card_pin = findViewById(R.id.etCardPin);
        card_mobile = findViewById(R.id.etCardMobile);
        cardHistorySource = new CardHistorySource(this);
        apiService = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);

        card_pin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length() == 8){
                    Drawable myIcon = getResources().getDrawable(R.drawable.ic_done_24dp);
                    myIcon.setBounds(0, 0, myIcon.getIntrinsicWidth(), myIcon.getIntrinsicHeight());
                    card_pin.setError("Good", myIcon);
                }else{
                    Drawable myIcon = getResources().getDrawable(R.drawable.ic_close_24dp);
                    myIcon.setBounds(0, 0, myIcon.getIntrinsicWidth(), myIcon.getIntrinsicHeight());
                    card_pin.setError("Wrong", myIcon);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        card_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str_pattern = "(^(?:\\+?88)?01[15-9]\\d{8}$)";
                if(s.length() == 11 && s.toString().matches(str_pattern)){
                    Drawable myIcon = getResources().getDrawable(R.drawable.ic_done_24dp);
                    myIcon.setBounds(0, 0, myIcon.getIntrinsicWidth(), myIcon.getIntrinsicHeight());
                    card_mobile.setError("Good", myIcon);
                }else{
                    Drawable myIcon = getResources().getDrawable(R.drawable.ic_close_24dp);
                    myIcon.setBounds(0, 0, myIcon.getIntrinsicWidth(), myIcon.getIntrinsicHeight());
                    card_mobile.setError("Wrong", myIcon);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() == true){

                    callCardApi(cardPinNo,mobileNo);

                }

            }
        });

    }

    private void callCardApi(String pin, String mobile) {

        Call<CardRechargeResponseApiError> call = apiService.getCardInfo("APONJON02301120170213V1",pin,mobile);
        call.enqueue(new Callback<CardRechargeResponseApiError>() {
            @Override
            public void onResponse(Call<CardRechargeResponseApiError> call, Response<CardRechargeResponseApiError> response) {
                if(response.isSuccessful()){
                    String text = response.body().getMessage();
                    boolean status = cardHistorySource.addMessage(text);
                    Log.i("CardHistoryHelper", "onResponse:..... "+status);
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CardRechargeResponseApiError> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean validate() {
        boolean valid = true;
        cardPinNo = card_pin.getText().toString();
        mobileNo = card_mobile.getText().toString();
        if (cardPinNo.isEmpty() || cardPinNo.length()!=8) {
            card_pin.setError("Please Enter Valid Email Address!");
            valid = false;
        } else {
            card_pin.setError(null);
        }
        if (mobileNo.isEmpty() || mobileNo.length() != 11) {
            card_mobile.setError("Please Enter Valid mobile number!");
            valid = false;
        } else {
            card_mobile.setError(null);
        }
        return valid;
    }
}
