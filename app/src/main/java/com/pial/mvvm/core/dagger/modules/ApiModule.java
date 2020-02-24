package com.pial.mvvm.core.dagger.modules;

import com.pial.mvvm.core.network.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private int REQUEST_TIMEOUT = 10;
    private String BASE_URL= "https://kl-sa-902.herokuapp.com/api/";

    @Singleton
    @Provides
    final OkHttpClient providesClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        return okHttpClient;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(providesClient())
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}