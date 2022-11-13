package com.example.test_dietapp1;

import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test_dietapp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_diary, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        final FloatingActionButton BF_button = (FloatingActionButton) findViewById(R.id.Breakfast);
        BF_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_eat_schedule);
            }
        });
        final FloatingActionButton Lunch_button = (FloatingActionButton) findViewById(R.id.Lunch);
        Lunch_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_exercise_schedule);
            }
        });
        final FloatingActionButton Dinner_button = (FloatingActionButton) findViewById(R.id.Dinner);
        Dinner_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Dinner_button.setVisibility(View.GONE);
            }
        });
    }

}