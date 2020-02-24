package com.pial.mvvm.core.network.request.login;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("phone_number")
    private String phoneNumber="";
    @SerializedName("password")
    private String password="";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
