package com.example.test_dietapp1;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test_dietapp1.databinding.ActivityMainBinding;
import com.example.test_dietapp1.sqlite.DatabaseHandler;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    OkHttpClient client  = new OkHttpClient();
    TextView txtResult;

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

        final FloatingActionsMenu Float_btn = (FloatingActionsMenu) findViewById(R.id.fab_menu);
        final FloatingActionButton BF_button = (FloatingActionButton) findViewById(R.id.Breakfast);
        BF_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_eat_schedule);
                Float_btn.collapse();
            }
        });
        final FloatingActionButton Lunch_button = (FloatingActionButton) findViewById(R.id.Lunch);
        Lunch_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_eat_schedule);
                Float_btn.collapse();
            }
        });
        final FloatingActionButton Dinner_button = (FloatingActionButton) findViewById(R.id.Dinner);
        Dinner_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_eat_schedule);
                Float_btn.collapse();
            }
        });
        final FloatingActionButton Exer_btn = (FloatingActionButton) findViewById(R.id.Exercise);
        Exer_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                navController.navigate(R.id.navigation_exercise_schedule);
                Float_btn.collapse();
            }
        });
        txtResult = (TextView) findViewById(R.id.tv_bodyMetrics);

        //Database
        DatabaseHandler DBHandler = new DatabaseHandler(this);
        final SQLiteDatabase readableDatabase = DBHandler.getReadableDatabase();
        readableDatabase.close();
    }

}