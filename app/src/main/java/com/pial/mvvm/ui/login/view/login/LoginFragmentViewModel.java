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
    public LiveData<ApiResponse> liveData = Transformations.switchMap(repositoryLiveDta,input -> input.onLoginAttemp(loginRequest));

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
            repositoryLiveDta.setValue(repository);
           // liveData = repository.onLoginAttemp(loginRequest);
        }
    }

    public LiveData<ApiResponse> getLoginInformation() {
        return liveData;
    }
}
