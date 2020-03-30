package com.pial.mvvm.ui.login.view.login;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
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
    public MediatorLiveData<ApiResponse> apiResponseLiveData = new MediatorLiveData<>();

    @Inject
    public LoginFragmentViewModel(LoginFragmentRepository repository, LoginRequest loginRequest, ResourceProvider resourceProvider) {
        this.repository = repository;
        this.loginRequest = loginRequest;
        this.resourceProvider = resourceProvider;
    }


    public void onLoginBtnClick() {
        if (loginRequest.getPhoneNumber().isEmpty()) {
            observableFieldForEmail.set(resourceProvider.getString(R.string.phone_empty));
        } else if (loginRequest.getPassword().isEmpty()) {
            observableFieldForEmail.set(resourceProvider.getString(R.string.password_empty));
        } else {
            apiResponseLiveData.addSource(repository.onLoginAttemp(loginRequest), apiResponse -> apiResponseLiveData.setValue(apiResponse));
            apiResponseLiveData.addSource(repository.onLoginAttempTwo(loginRequest), apiResponse -> apiResponseLiveData.setValue(apiResponse));
        }
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        repository.onClearDisposable();
    }
}
