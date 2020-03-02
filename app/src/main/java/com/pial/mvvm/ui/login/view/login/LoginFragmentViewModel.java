package com.pial.mvvm.ui.login.view.login;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.core.network.response.ApiResponse;

import javax.inject.Inject;

public class LoginFragmentViewModel extends ViewModel {
    private LoginFragmentRepository repository;
    public LoginRequest loginRequest;
    private MutableLiveData<LoginFragmentRepository> repositoryLiveDta = new MutableLiveData<>();
    public MediatorLiveData<ApiResponse> liveData = new MediatorLiveData<>();

    @Inject
    public LoginFragmentViewModel(LoginFragmentRepository repository,LoginRequest loginRequest) {
        this.repository = repository;
        this.loginRequest = loginRequest;
    }


    public void onLoginBtnClick() {
        if (loginRequest.getPhoneNumber().isEmpty()) {
            Log.e("dgjhdgfhj","phone empty");
        } else if (loginRequest.getPassword().isEmpty()) {
            Log.e("dgjhdgfhj","password empty");
        } else {
            liveData.addSource(repository.onLoginAttemp(loginRequest),apiResponse -> liveData.setValue(apiResponse));
        }
    }

    public LiveData<ApiResponse> getLoginInformation() {
        return liveData;
    }
}
