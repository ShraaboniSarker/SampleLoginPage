package com.example.shraboni.lifechordtestproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardRechargeResponse {

    @SerializedName("card_info")
    @Expose
    private List<CardRechargeData> cardInfo = null;
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;

    public List<CardRechargeData> getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(List<CardRechargeData> cardInfo) {
        this.cardInfo = cardInfo;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
