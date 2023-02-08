package com.example.test_dietapp1.ui.dashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.test_dietapp1.R;
import com.google.android.material.button.MaterialButton;

public class AddFoodStuffActivity extends AppCompatActivity {

    private TextView txt_name, txt_unit1, txt_unit2;
    private Spinner option, unit;
    private LinearLayout view_selection;
    private MaterialButton btn_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setTitle("Tạo thực phẩm mới");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_foodstuff);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_name = findViewById(R.id.editTextTextMultiLine);
        txt_unit1 = findViewById(R.id.name_foodstuff2);
        txt_unit2 = findViewById(R.id.unit_number);
        option = findViewById(R.id.name_foodstuff1);
        view_selection = (LinearLayout) findViewById(R.id.view2);
        unit = findViewById(R.id.unit);
        btn_continue = (MaterialButton) findViewById(R.id.btn_submit);

        ArrayAdapter<CharSequence> adapter_option = ArrayAdapter.createFromResource(this, R.array.option_array, android.R.layout.simple_spinner_item);
        adapter_option.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        option.setAdapter(adapter_option);

        ArrayAdapter<CharSequence> adapter_unit = ArrayAdapter.createFromResource(this, R.array.unit_array, android.R.layout.simple_spinner_item);
        adapter_unit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit.setAdapter(adapter_unit);

        option.setSelection(0);
        unit.setSelection(0);

        option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    view_selection.setVisibility(View.VISIBLE);
                }
                else view_selection.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButtonSubmit(view);
            }
        });

    }

    public void clickButtonSubmit(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
            {
                if (CheckAllFields()) {
                    //do something
                }
                break;
            }
        }
    }
    private boolean CheckAllFields() {
        if (txt_name.getText().length() == 0) {
            txt_name.setError("Không được để trống tên!");
            return false;
        }
        if (txt_unit1.getText().length() == 0) {
            txt_unit1.setError("Điền vào đây!");
            return false;
        }
        if (txt_unit2.getText().length() == 0 && option.getSelectedItemPosition() == 0) {
            txt_unit2.setError("Bắt buộc!");
            return false;
        }

        return true;
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