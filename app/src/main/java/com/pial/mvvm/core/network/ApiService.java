package com.pial.mvvm.core.network;

import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.core.network.response.login.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("auth/api-token-auth/")
    Single<LoginResponse> onLoginRequest(@Body LoginRequest loginRequest);
}
