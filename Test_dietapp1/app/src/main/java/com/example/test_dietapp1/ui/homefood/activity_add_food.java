package com.example.test_dietapp1.ui.homefood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test_dietapp1.R;

public class activity_add_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Tạo mới món ăn");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}