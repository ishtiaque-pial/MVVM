package com.pial.mvvm.ui.login.view.login;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

import com.pial.mvvm.core.network.ApiService;
import com.pial.mvvm.utils.factory.ViewModelProviderFactory;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class LoginFragmentModule {
    @Provides
    LoginFragmentViewModel provideLoginFragmentViewModel(LoginFragmentRepository repository){
        return new LoginFragmentViewModel(repository);
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
    ViewModelProvider.Factory provideLoginFragmentFactory(LoginFragmentViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
