package com.pial.mvvm.core.dagger.modules;

import android.content.Context;

import com.pial.mvvm.core.AppApplication;
import com.pial.mvvm.utils.manegers.SharedHelper;
import com.pial.mvvm.utils.resource.ResourceProvider;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Singleton
    @Provides
    Context provideContext(AppApplication application){
        return application;
    }

    @Singleton
    @Provides
    Gson provideGson(){
        return new Gson();
    }

    @Singleton
    @Provides
    ResourceProvider provideResource(Context context){
        return new ResourceProvider(context);
    }

    @Singleton
    @Provides
    SharedHelper provideSharedHelper(Context context){
        return new SharedHelper(context);
    }


}
