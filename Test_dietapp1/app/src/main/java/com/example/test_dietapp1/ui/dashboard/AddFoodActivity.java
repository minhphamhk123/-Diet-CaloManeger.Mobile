package com.example.test_dietapp1.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.MonAn;
import com.example.test_dietapp1.sqlite.MonAnDAO;

public class AddFoodActivity extends AppCompatActivity implements View.OnClickListener{
private EditText TenMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Tạo mới món ăn");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TenMonAn = findViewById(R.id.editTextTextMultiLine);

        findViewById(R.id.btn_submit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                MonAnDAO dao = new MonAnDAO(this);
                MonAn ma = new MonAn();

                ma.setTenMA(TenMonAn.getText().toString());
                dao.insertMonAn(ma);
                Toast.makeText(this,"Mon An duoc them thanh cong",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //Title bar back press triggers onBackPressed()
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Both navigation bar back press and title bar back press will trigger this method
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ) {
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }
}