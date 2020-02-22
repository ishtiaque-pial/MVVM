package com.pial.mvvm.core.dagger.components;


import com.pial.mvvm.core.AppApplication;
import com.pial.mvvm.core.dagger.builders.ActivityBuilder;
import com.pial.mvvm.core.dagger.modules.ApiModule;
import com.pial.mvvm.core.dagger.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        ApiModule.class,
        ActivityBuilder.class})

public interface AppMainComponent extends AndroidInjector<AppApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<AppApplication> {}
}
