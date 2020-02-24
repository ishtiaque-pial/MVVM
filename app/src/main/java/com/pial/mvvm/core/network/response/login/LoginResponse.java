package com.pial.mvvm.core.network.response.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    /**
     * refresh : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoicmVmcmVzaCIsImV4cCI6MTU2Njc1Mjc2MCwianRpIjoiMmYyNDZhYzViZjc0NGYzNzk4ZTljY2IzMWM0YmE1MzAiLCJ1c2VyX2lkIjozMH0.2V1RF2hruxDVGoqcX-5DGlS2PmDUv0TcyaaSn7zzt3M
     * access : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNTY2MTUxNTYwLCJqdGkiOiJhMDRjODhiODAxMGQ0YzU2YjBjNGMyNDFlODNjMTZiNyIsInVzZXJfaWQiOjMwfQ.ZSmaK4_G62M4F4iT1yAy4fEEF_OeBNFICO1btIsM1cY
     * access_token_lifetime : 3600
     * refresh_token_lifetime : 604800
     * user : [{"id":30,"phone_number":"+8801521218271","email":"team122@example.co16","name":"Pial Pial","profile_picture":""}]
     * profile_type : Customer
     * customer : {"qr_code":"https://sgp1.digitaloceanspaces.com/ggez/kole_902_jkshd842/user/customer/qr/30.png?AWSAccessKeyId=HYHXRSYF2HMNWM2U5MXV&Signature=%2BVd24fT3eJ20omwGCbujfOCxcXk%3D&Expires=1566151561"}
     */

    @SerializedName("refresh")
    private String refresh;
    @SerializedName("access")
    private String access;
    @SerializedName("access_token_lifetime")
    private int accessTokenLifetime;
    @SerializedName("refresh_token_lifetime")
    private int refreshTokenLifetime;
    @SerializedName("profile_type")
    private String profileType;
    @SerializedName("customer")
    private CustomerBean customer;
    @SerializedName("user")
    private List<UserBean> user;

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getAccessTokenLifetime() {
        return accessTokenLifetime;
    }

    public void setAccessTokenLifetime(int accessTokenLifetime) {
        this.accessTokenLifetime = accessTokenLifetime;
    }

    public int getRefreshTokenLifetime() {
        return refreshTokenLifetime;
    }

    public void setRefreshTokenLifetime(int refreshTokenLifetime) {
        this.refreshTokenLifetime = refreshTokenLifetime;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }
}
