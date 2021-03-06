package com.pial.mvvm.ui.login.view.login;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.pial.mvvm.R;
import com.pial.mvvm.core.base.BaseFragment;
import com.pial.mvvm.databinding.FragmentLoginBinding;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment<LoginFragmentViewModel> {
    private FragmentLoginBinding binding;
    private LoginFragmentViewModel viewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setViewModel(viewModel);
        viewModel.getLoginInformation().observe(getViewLifecycleOwner(),apiResponse -> {
            switch (apiResponse.status) {
                case LOADING:
                    Log.e("fgdshf","LOADING");
                    break;
                case SUCCESS:
                    Log.e("fgdshf","SUCCESS");
                    break;
                case ERROR:
                    Log.e("fgdshf","ERROR "+apiResponse.error.getMessage());
                    break;
            }
        });

        return binding.getRoot();
    }

    @Override
    public LoginFragmentViewModel getViewModel() {
        viewModel = new ViewModelProvider(this, factory).get(LoginFragmentViewModel.class);
        return viewModel;
    }
}
