package com.example.test_dietapp1.ui.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.test_dietapp1.LoginActivity;
import com.example.test_dietapp1.MainActivity;
import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.DangNhap;
import com.example.test_dietapp1.module.NguoiDung;
import com.example.test_dietapp1.sqlite.DangNhapDAO;
import com.example.test_dietapp1.sqlite.NguoiDungDAO;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SetUpForUser extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    ToggleButton male,female;
    Button check_btn;
    ImageView subW,addW,subH,addH,subA,addA;
    TextView Age, Height, Weight;
    EditText minute,day;

    String personName;
    String personEmail;
    String ID;
    int Sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_for_user);
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);
        DangNhapDAO dangNhapDAO = new DangNhapDAO(this);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null)
        {
            personName = acct.getDisplayName();
            personEmail = acct.getEmail();
            ID = acct.getId();
            DangNhap dangNhap = new DangNhap(ID,personEmail,"Example");
            if(dangNhapDAO.getByID(ID) != dangNhap)
                dangNhapDAO.insertDangNhap(dangNhap);
        }

        male = (ToggleButton) findViewById(R.id.SexMale);
        female = (ToggleButton) findViewById(R.id.SexFemale);
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if(isChecked == true)
                {
                    female.setChecked(false);
                    Sex = 1;
                }
            }
        });
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if(isChecked == true)
                {
                    male.setChecked(false);
                    Sex = 0;
                }
            }
        });


        subW = (ImageView) findViewById(R.id.SubWeight);
        addW = (ImageView) findViewById(R.id.AddWeight);

        subA = (ImageView) findViewById(R.id.SubAge);
        addA = (ImageView) findViewById(R.id.AddAge);

        subH = (ImageView) findViewById(R.id.HeightSub);
        addH = (ImageView) findViewById(R.id.HeightPlus);

        Age = (TextView) findViewById(R.id.Age);
        Height = (TextView) findViewById(R.id.Height);
        Weight = (TextView) findViewById(R.id.Weight);

        minute = (EditText) findViewById(R.id.minuteDay);
        day = (EditText) findViewById(R.id.dayWeek);

        check_btn = (Button) findViewById(R.id.CheckNext);
        check_btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               if(ID==null||personName==null)
               {
                   ID="guest";
                   personName="guest";
                   personEmail="none";
               }
               NguoiDung nd = new NguoiDung(ID,personName,Float.parseFloat(Weight.getText().toString()),Float.parseFloat(Height.getText().toString()),Sex,0,personEmail,"SDT",Age.getText().toString());
               nguoiDungDAO.insertNguoiDung(nd);
               NavigateToMainActivity();
           }
        });
    }

    void NavigateToMainActivity()
    {
        Intent intent = new Intent(SetUpForUser.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}