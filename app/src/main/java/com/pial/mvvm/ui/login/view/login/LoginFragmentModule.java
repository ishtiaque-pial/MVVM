package com.pial.mvvm.ui.login.view.login;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

import com.pial.mvvm.core.network.ApiService;
import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.utils.factory.ViewModelProviderFactory;
import com.pial.mvvm.utils.resource.ResourceProvider;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class LoginFragmentModule {
    @Provides
    LoginFragmentViewModel provideLoginFragmentViewModel(LoginFragmentRepository repository, LoginRequest loginRequest, ResourceProvider resourceProvider){
        return new LoginFragmentViewModel(repository,loginRequest,resourceProvider);
    }

    @Provides
    LoginFragmentRepository provideLoginFragmentRepository(ApiService apiService, CompositeDisposable disposable){
        return new LoginFragmentRepository(apiService, disposable);
    }

    @Provides
    CompositeDisposable procideLoginFragmentCompositeDisposal(){
        return new CompositeDisposable();
    }

    @Provides
    LoginRequest provideLoginRequest(){
        return new LoginRequest();
    }

    @Provides
    ViewModelProvider.Factory provideLoginFragmentFactory(LoginFragmentViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
