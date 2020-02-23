package com.pial.mvvm.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.pial.mvvm.R;
import com.pial.mvvm.core.base.BaseActivity;
import com.pial.mvvm.utils.resource.ResourceProvider;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<LoginActivityViewModel> {

    LoginActivityViewModel viewModel;
    @Inject
    ViewModelProvider.Factory factory;
    @Inject
    ResourceProvider resourceProvider;

    @Override
    public LoginActivityViewModel getViewModel() {
        viewModel = new ViewModelProvider(this, factory).get(LoginActivityViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }
}
