package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseTotalTagihan {
    @SerializedName("total_tagihan") Integer total_tagihan;

    public Integer getTotal_tagihan() {
        return total_tagihan;
    }

    public void setTotal_tagihan(Integer total_tagihan) {
        this.total_tagihan = total_tagihan;
    }
}
