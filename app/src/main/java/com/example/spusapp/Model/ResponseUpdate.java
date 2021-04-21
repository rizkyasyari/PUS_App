package com.example.spusapp.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUpdate {
    @SerializedName("code") Integer code;
    @SerializedName("message") String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
