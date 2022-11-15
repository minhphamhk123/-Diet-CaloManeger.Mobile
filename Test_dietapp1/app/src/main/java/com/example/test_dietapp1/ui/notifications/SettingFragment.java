package com.example.test_dietapp1.ui.notifications;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.test_dietapp1.MainActivity;
import com.example.test_dietapp1.R;


public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting,container,false);
        Button btn1 =  (Button) v.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BMRFragment bmr = new BMRFragment();
//                FragmentManager fm = getFragmentManager();
//                fm.beginTransaction().replace(R.id.container,bmr, bmr.getTag()).commit();
                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_BMRFragment);
            }
        });

        Button btn2 =  (Button) v.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_macroFragment);
            }
        });
        Button btn3 =  (Button) v.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_settingFragment_to_watterFragment);
            }
        });
        return v;
    }



}