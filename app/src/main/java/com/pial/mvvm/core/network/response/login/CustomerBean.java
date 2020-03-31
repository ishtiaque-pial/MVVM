package com.pial.mvvm.core.network.response.login;

import com.google.gson.annotations.SerializedName;

public class CustomerBean {
    /**
     * qr_code : https://sgp1.digitaloceanspaces.com/ggez/kole_902_jkshd842/user/customer/qr/30.png?AWSAccessKeyId=HYHXRSYF2HMNWM2U5MXV&Signature=%2BVd24fT3eJ20omwGCbujfOCxcXk%3D&Expires=1566151561
     */

    @SerializedName("qr_code")
    private String qrCode;

    @SerializedName("user")
    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
