package com.example.test_dietapp1.ui.addinfab;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.databinding.FragmentEatScheduleBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class fragment_eat_schedule extends Fragment {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private ImageButton btnClick, btnScan;
    private EditText txtSearch;
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
        @SuppressLint("InlinedApi")
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private FragmentEatScheduleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_eat_schedule_, container,false);
        btnClick = (ImageButton) rootView.findViewById(R.id.btn_Close);
        txtSearch = (EditText) rootView.findViewById(R.id.et_Finding_Food);
        btnClick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                getActivity().getFragmentManager().popBackStack();
            }
        });
        binding = FragmentEatScheduleBinding.inflate(inflater, container, false);
        //return binding.getRoot();

        btnScan=(ImageButton) rootView.findViewById(R.id.btn_QR_Food);
        btnScan.setOnClickListener(view -> {
            scanCode();
        });
        return rootView;
    }

    private void scanCode() {
        ScanOptions scanner = new ScanOptions();
        scanner.setPrompt("Quét mã QR");
        scanner.setBeepEnabled(true);
        scanner.setOrientationLocked(true);
        scanner.setCaptureActivity(CaptureAct.class);
        QRLaucher.launch(scanner);
    }

    ActivityResultLauncher<ScanOptions> QRLaucher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set up the user interaction to manually show or hide the system UI.

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
    }







    @Nullable
    private ActionBar getSupportActionBar() {
        ActionBar actionBar = null;
        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            actionBar = activity.getSupportActionBar();
        }
        return actionBar;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}