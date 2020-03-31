package com.pial.mvvm.ui.login.view.login;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pial.mvvm.R;
import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.core.network.response.ApiResponse;
import com.pial.mvvm.utils.resource.ResourceProvider;

import javax.inject.Inject;

public class LoginFragmentViewModel extends ViewModel {
    private LoginFragmentRepository repository;
    private ResourceProvider resourceProvider;
    public LoginRequest loginRequest;
    public ObservableField<String> observableFieldForEmail = new ObservableField<>();
    public ObservableField<String> observableFieldForPassword = new ObservableField<>();
    MutableLiveData<ApiResponse> apiResponseLiveData;
    private String token = "";

    @Inject
    public LoginFragmentViewModel(LoginFragmentRepository repository, LoginRequest loginRequest, ResourceProvider resourceProvider) {
        this.repository = repository;
        this.loginRequest = loginRequest;
        this.resourceProvider = resourceProvider;
        apiResponseLiveData = this.repository.responseLiveData;
    }

    void setUserInfo(String token) {
        this.token = token;
    }

    public void onLoginBtnClick() {
        if (loginRequest.getPhoneNumber().isEmpty()) {
            observableFieldForEmail.set(resourceProvider.getString(R.string.phone_empty));
        } else if (loginRequest.getPassword().isEmpty()) {
            observableFieldForEmail.set(resourceProvider.getString(R.string.password_empty));
        } else {
            apiResponseLiveData = repository.onLoginAttemp(loginRequest);
        }
    }

    public void onProfileGet() {
        if (!token.isEmpty()) {
            apiResponseLiveData = repository.onGetUserInfo("JWT "+token);
        }

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClearDisposable();
    }
}
