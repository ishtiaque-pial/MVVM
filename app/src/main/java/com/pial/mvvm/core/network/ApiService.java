package com.pial.mvvm.core.network;

import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.core.network.response.login.CustomerBean;
import com.pial.mvvm.core.network.response.login.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("auth/api-token-auth/")
    Single<LoginResponse> onLoginRequest(@Body LoginRequest loginRequest);

    @GET("account/customer/{user}/")
    Single<CustomerBean> onGetProfileResponse(@Header("Authorization") String token, @Path("user") String userID);
}
