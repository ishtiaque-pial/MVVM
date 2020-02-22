package com.pial.mvvm.core;

import com.pial.mvvm.core.dagger.components.DaggerAppMainComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AppApplication  extends DaggerApplication {
    private static AppApplication instance;
    private static final String TAG = AppApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized AppApplication getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppMainComponent.builder().create(this);
    }
}
