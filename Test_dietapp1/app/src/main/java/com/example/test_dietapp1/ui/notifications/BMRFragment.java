package com.example.test_dietapp1.ui.notifications;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.test_dietapp1.R;

public class BMRFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}