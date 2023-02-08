package com.example.test_dietapp1.ui.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test_dietapp1.LoginActivity;
import com.example.test_dietapp1.MainActivity;
import com.example.test_dietapp1.R;
import com.example.test_dietapp1.sqlite.DangNhapDAO;
import com.example.test_dietapp1.sqlite.NguoiDungDAO;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class StartApp extends AppCompatActivity {

    Button Email_btn, Guest_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
        getSupportActionBar().hide();

        DangNhapDAO dao = new DangNhapDAO(this);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null&&dao.getByID(account.getId())!=null){NavigateToMainActivity();}
        Email_btn = (Button) findViewById(R.id.LoginEmail);
        Guest_btn = (Button) findViewById(R.id.LoginGuest);

        Email_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goToAnActivityLoginEmail(v);
            }
        });
        Guest_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                goToAnotherActivityLoginGuest(v);
            }
        });
    }

    public void goToAnActivityLoginEmail(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToAnotherActivityLoginGuest(View view) {
        Intent intent = new Intent(this, SetUpForUser.class);
        startActivity(intent);
    }

    void NavigateToMainActivity()
    {
        Intent intent = new Intent(StartApp.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}