package com.pial.mvvm.ui.login.view.login;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

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
        return binding.getRoot();
    }

    @Override
    public LoginFragmentViewModel getViewModel() {
        viewModel = new ViewModelProvider((ViewModelStoreOwner) getViewLifecycleOwner(), factory).get(LoginFragmentViewModel.class);
        return viewModel;
    }
}
