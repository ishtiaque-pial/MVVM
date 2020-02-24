package com.pial.mvvm.core.network.response.login;

import com.google.gson.annotations.SerializedName;

public class UserBean {
    /**
     * id : 30
     * phone_number : +8801521218271
     * email : team122@example.co16
     * name : Pial Pial
     * profile_picture :
     */

    @SerializedName("id")
    private int id;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("profile_picture")
    private String profilePicture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
