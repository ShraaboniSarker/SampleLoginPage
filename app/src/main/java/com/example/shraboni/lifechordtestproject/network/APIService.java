package com.example.shraboni.lifechordtestproject.network;

import com.example.shraboni.lifechordtestproject.model.CardRechargeResponseApiError;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/api/prepaid/card_recharge")
    Call<CardRechargeResponseApiError> getCardInfo(
            @Field("api_key") String api_key,
            @Field("pin") String pin,
            @Field("mobile") String mobile);
}
