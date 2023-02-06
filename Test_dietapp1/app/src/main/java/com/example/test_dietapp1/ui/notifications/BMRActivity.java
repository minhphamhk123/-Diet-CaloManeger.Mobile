package com.example.test_dietapp1.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
    }
}