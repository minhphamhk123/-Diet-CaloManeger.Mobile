package com.example.test_dietapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test_dietapp1.sqlite.DangNhapDAO;
import com.example.test_dietapp1.ui.notifications.SettingActivity;
import com.example.test_dietapp1.ui.startup.SetUpForUser;
import com.example.test_dietapp1.ui.startup.StartApp;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button Login_btn;
    static int check = 0;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView google_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).

                requestEmail().

                build();

        gsc = GoogleSignIn.getClient(this, gso);

        google_btn = findViewById(R.id.google_btn);
        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        email = (EditText) findViewById(R.id.EmailText);
        password = (EditText) findViewById(R.id.PasswordIn);
        Login_btn = (Button) findViewById(R.id.login_btn);
        Login_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                NavigateToMainActivity();
            }
        });
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent((data));
            try{
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            }catch(ApiException e)
            {
                Toast.makeText(getApplicationContext(),"Something wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
    void navigateToSecondActivity()
    {
        DangNhapDAO dangNhapDAO = new DangNhapDAO(this);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        try {if(account != null&&dangNhapDAO.getByID(account.getId()).getID()!=null){NavigateToMainActivity();
        return;
        }}catch (Exception e)
        {

        }
        Intent intent = new Intent(LoginActivity.this, SetUpForUser.class);
        startActivity(intent);
    }

    void NavigateToMainActivity()
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /*void SignOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>(){
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(LoginActivity.this, StartApp.class));
            }
        });
    }*/
}