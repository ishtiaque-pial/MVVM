package com.pial.mvvm.ui.login;

import androidx.lifecycle.ViewModelProvider;

import com.pial.mvvm.utils.factory.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    @Provides
    LoginActivityViewModel providesLoginActivityViewModel(){
        return new LoginActivityViewModel();
    }

}
