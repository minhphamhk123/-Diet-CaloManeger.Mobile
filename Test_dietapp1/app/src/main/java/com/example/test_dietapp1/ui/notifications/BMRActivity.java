package com.example.test_dietapp1.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.test_dietapp1.R;

public class BMRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content,new BMRFragment())
                .commit();
        setTitle("Cập nhật BMR");
        //PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        //sp.edit().putString("age","100").apply();

    }
    @Override
    public void onStop() {
        super.onStop();
    }
}