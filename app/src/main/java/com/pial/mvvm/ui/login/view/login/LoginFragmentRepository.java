package com.pial.mvvm.ui.login.view.login;

import com.pial.mvvm.core.network.ApiService;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginFragmentRepository {
    private ApiService apiService;
    private CompositeDisposable disposable;

    @Inject
    public LoginFragmentRepository(ApiService apiService, CompositeDisposable disposable) {
        this.apiService = apiService;
        this.disposable = disposable;
    }
}
