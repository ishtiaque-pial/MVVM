package com.pial.mvvm.ui.login.view.login;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginFragmentProvider {
    @ContributesAndroidInjector(modules = LoginFragmentModule.class)
    abstract LoginFragment provideLoginFragment();
}
