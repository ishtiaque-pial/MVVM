package com.pial.mvvm.ui.login.view.login;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class LoginFragmentViewModel extends ViewModel {
    private LoginFragmentRepository repository;

    @Inject
    public LoginFragmentViewModel(LoginFragmentRepository repository) {
        this.repository = repository;
    }
}
