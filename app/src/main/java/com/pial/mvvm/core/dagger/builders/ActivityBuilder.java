package com.pial.mvvm.core.dagger.builders;

import com.pial.mvvm.ui.login.LoginActivity;
import com.pial.mvvm.ui.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributeLoginActivity();
}
