package com.example.test_dietapp1.ui.dashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.MonAn;
import com.example.test_dietapp1.module.NguyenLieu;
import com.example.test_dietapp1.sqlite.MonAnDAO;
import com.google.android.material.button.MaterialButton;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class AddFoodActivity extends AppCompatActivity  implements View.OnClickListener {
    private EditText TenMonAn;
    private AppCompatImageButton btn_upload;
    private MaterialButton btn_create_food;
    private Button btn_add_food_stuff;
    private ImageView image;
    private static final int CAMERA_REQUEST = 1;
    private MonAn ma = new MonAn();
    private static List<NguyenLieu> listNL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setTitle("Tạo mới món ăn");
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TenMonAn = (EditText) findViewById(R.id.editTextTextMultiLine);
        btn_upload = (AppCompatImageButton) findViewById(R.id.imageButton);
        btn_upload.setOnClickListener(this);
        btn_create_food = (MaterialButton) findViewById(R.id.btn_submit);
        btn_create_food.setOnClickListener(this);
        btn_add_food_stuff = (Button) findViewById(R.id.btn_add_stuff);
        btn_add_food_stuff.setOnClickListener(this);
        image = (ImageView) findViewById(R.id.imageView);
    }

    private boolean CheckAllFields() {
        if (TenMonAn.length() == 0) {
            TenMonAn.setError("Không được để trống!");
            return false;
        }
        else {
            ma.setTenMA(TenMonAn.getText().toString());
        }

        if (listNL == null) {
            showError("Thêm thực phẩm là bắt buộc!");
            return  false;
        }

        return true;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            ma.setHinhAnh(byteArray);
        }
    }

    public void clickButtonSubmit(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                MonAnDAO dao = new MonAnDAO(this);
                dao.insertMonAn(ma);
                showSuccess("Thêm món ăn thành công");
                break;
        }
    }

    public void showError(String str) {
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        View view = toast.getView();
        view.getBackground().setColorFilter(Color.parseColor("#e01649"), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(Color.parseColor("#ffffff"));
        toast.show();
    }
    public void showSuccess(String str) {
        Toast toast = Toast.makeText(this,str,Toast.LENGTH_SHORT);
        View v = toast.getView();
        v.getBackground().setColorFilter(Color.parseColor("#6ce620"), PorterDuff.Mode.SRC_IN);
        TextView text = v.findViewById(android.R.id.message);
        text.setTextColor(Color.parseColor("#ffffff"));
        toast.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit: {
                boolean isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    clickButtonSubmit(v);
                }
                break;
            }
            case R.id.imageButton: {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                } else {
                    showError("Không thể mở Camera!");
                }
                break;
            }
            case R.id.btn_add_stuff: {
                startActivity(new Intent(this, OpenFoodStuffActivity.class));
                break;
            }
            default: break;
        }
    }

    public List<NguyenLieu> getListNL(){
        return listNL;
    }
    public void setListNL(List<NguyenLieu> list){
        listNL = list;
    }
}