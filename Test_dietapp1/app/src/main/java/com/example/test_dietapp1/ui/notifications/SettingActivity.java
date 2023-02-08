package com.example.test_dietapp1.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.ui.startup.SetUpForUser;
import com.example.test_dietapp1.ui.startup.StartApp;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SettingActivity extends AppCompatActivity {

    Button LogOut;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        setTitle("Cài đặt");
        setContentView(R.layout.activity_setting);
        Button btn3 =  (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingActivity.this,WatterActivity.class);
                startActivity(in);
            }
        });
        Button btn1 =  (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingActivity.this,BMRActivity.class);
                startActivity(in);
            }
        });
        Button btn2 =  (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(SettingActivity.this,MacroActivity.class);
                startActivity(in);
            }
        });
        LogOut = (Button) findViewById(R.id.LogOut);
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignOut();
            }
        });
    }

    void SignOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>(){
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(SettingActivity.this, StartApp.class));
            }
        });
    }
}