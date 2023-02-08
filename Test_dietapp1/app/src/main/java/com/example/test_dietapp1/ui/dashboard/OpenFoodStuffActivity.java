package com.example.test_dietapp1.ui.dashboard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.MonAn;
import com.example.test_dietapp1.sqlite.MonAnDAO;
import com.example.test_dietapp1.ui.Adapter.ListFoodAdapter;
import com.example.test_dietapp1.ui.addinfab.CaptureAct;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.List;

public class OpenFoodStuffActivity extends AppCompatActivity {
    private ImageButton btn_scan;
    private ListView listView;
    private List<MonAn> listAllNL;
    private ListFoodAdapter adapter;

    private AlertDialog dialog;
    private Button btn_open_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Thêm thực phẩm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_open_foodstuff);
        btn_scan = (ImageButton) findViewById(R.id.btn_QR_Scan);
        btn_scan.setOnClickListener(view -> {
            scanCode();
        });

        AnhXa();
        adapter = new ListFoodAdapter(this, R.layout.food_line, listAllNL);
        listView.setAdapter(adapter);

        btn_open_dialog = (Button) findViewById(R.id.btn_add_stuff);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thêm thực phẩm");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_food_stuff, null);
        TextView submit, cancel;
        cancel = view.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        submit = view.findViewById(R.id.btn_add_stuff);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
                dialog.dismiss();
            }
        });

        builder.setView(view);
        dialog = builder.create();
        btn_open_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    private void AnhXa()
    {
        listView = (ListView) findViewById(R.id.lv_all_food);
        listAllNL = new MonAnDAO(this).getMonAnALL();
    }

    private void scanCode() {
        ScanOptions scanner = new ScanOptions();
        scanner.setPrompt("Đưa camera vào khu vực cần quét");
        scanner.setBeepEnabled(true);
        scanner.setOrientationLocked(true);
        scanner.setCaptureActivity(CaptureAct.class);
        QRLaucher.launch(scanner);
    }

    ActivityResultLauncher<ScanOptions> QRLaucher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Kết quả");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("Thêm vào nhật ký", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });
}