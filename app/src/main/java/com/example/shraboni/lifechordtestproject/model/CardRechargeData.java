package com.example.shraboni.lifechordtestproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardRechargeData {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("service_period")
    @Expose
    private String servicePeriod;
    @SerializedName("serial")
    @Expose
    private String serial;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
