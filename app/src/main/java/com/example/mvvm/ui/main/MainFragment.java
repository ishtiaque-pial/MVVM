package com.example.mvvm.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mvvm.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button buttonOne,buttonTwo;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.main_fragment, container, false);
        buttonOne = view.findViewById(R.id.buttonOne);
        buttonTwo = view.findViewById(R.id.buttonTwo);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action =  MainFragmentDirections.actionMainFragmentToOneFragment("ghfghf");
                Navigation.findNavController(view).navigate(action);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.twoFragment);
            }
        });

        try {
            Log.e("fhjgfdhj", "" + MainFragmentArgs.fromBundle(getArguments()).getFromWhere());
        } catch (Exception e) {

        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
