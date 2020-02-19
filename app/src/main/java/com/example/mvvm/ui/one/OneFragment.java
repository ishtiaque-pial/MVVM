package com.example.mvvm.ui.one;


import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_one, container, false);
        Log.e("fhjgfdhj",""+OneFragmentArgs.fromBundle(getArguments()).getFromWhere());
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */){

            @Override
            public void handleOnBackPressed() {
                NavDirections action  = OneFragmentDirections.actionOneFragmentToMainFragment("good boy");
                Navigation.findNavController(view).navigate(action);
                // NavDirections action =  OneFr.actionMainFragmentToOneFragment("ghfghf");
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
