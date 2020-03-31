package com.pial.mvvm.ui.login.view.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pial.mvvm.core.network.ApiService;
import com.pial.mvvm.core.network.request.login.LoginRequest;
import com.pial.mvvm.core.network.response.ApiResponse;
import com.pial.mvvm.core.network.response.login.CustomerBean;
import com.pial.mvvm.core.network.response.login.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginFragmentRepository {
    private ApiService apiService;
    private CompositeDisposable disposable;
    public  MutableLiveData<ApiResponse> responseLiveData = new MutableLiveData<>();

    @Inject
    LoginFragmentRepository(ApiService apiService, CompositeDisposable disposable) {
        this.apiService = apiService;
        this.disposable = disposable;
    }

    MutableLiveData<ApiResponse> onLoginAttemp(LoginRequest loginRequest) {
        responseLiveData.setValue(ApiResponse.loading());
        Single<LoginResponse> observer = apiService.onLoginRequest(loginRequest);
        disposable.add(observer
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse loginResponse) {
                        responseLiveData.postValue(ApiResponse.success(loginResponse));
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseLiveData.postValue(ApiResponse.error(e));
                    }
                }));
        return responseLiveData;
    }

    public MutableLiveData<ApiResponse> onGetUserInfo(String token) {
        responseLiveData.setValue(ApiResponse.loading());
        Single<CustomerBean> observer = apiService.onGetProfileResponse(token,"850");
        disposable.add(observer
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CustomerBean>() {
                    @Override
                    public void onSuccess(CustomerBean customerBean) {
                        responseLiveData.postValue(ApiResponse.success(customerBean));
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseLiveData.postValue(ApiResponse.error(e));
                    }
                }));
        return responseLiveData;
    }

    void onClearDisposable(){
        disposable.clear();
    }

}
