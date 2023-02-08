package com.example.test_dietapp1.ui.notifications;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.test_dietapp1.MainActivity;
import com.example.test_dietapp1.R;
import com.example.test_dietapp1.databinding.FragmentNotificationsBinding;
import com.example.test_dietapp1.module.NguoiDung;
import com.example.test_dietapp1.sqlite.NguoiDungDAO;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;
    TextView person_name,height,weight,BMI,TrangThai;
    ImageView per_ima;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final ImageButton btn_ic_setting = root.findViewById(R.id.ic_setting);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(root.getContext());
        person_name = root.findViewById(R.id.per_name);
        per_ima = root.findViewById(R.id.per_image);
        height = root.findViewById(R.id.tv_HeightMetrics);
        weight = root.findViewById(R.id.tv_WeightMetrics);
        BMI = root.findViewById(R.id.tv_BMIMetrics);
        TrangThai = root.findViewById(R.id.tv_WeightHeader);


        NguoiDungDAO dao = new NguoiDungDAO(root.getContext());
        NguoiDung nd = dao.getByMaMA(account.getId());
        height.setText(String.valueOf(nd.getCHieuCao()));
        weight.setText(String.valueOf(nd.getCanNang()));
        BMI.setText(String.valueOf(nd.getCanNang()/((nd.getCHieuCao()/100)*2)));

        if(nd.getCanNang()/((nd.getCHieuCao()/100)*2) <18.5)
        {
            TrangThai.setText("Thiếu cân");
            nd.setTienTrinh(1);
            dao.updateNguoiDung(nd);
        }
        if(nd.getCanNang()/((nd.getCHieuCao()/100)*2) >18.5&&nd.getCanNang()/((nd.getCHieuCao()/100)*2)<22.9)
        {
            TrangThai.setText("Bình thường");
            nd.setTienTrinh(2);
            dao.updateNguoiDung(nd);
        }
        if(nd.getCanNang()/((nd.getCHieuCao()/100)*2) >23&&nd.getCanNang()/((nd.getCHieuCao()/100)*2)<24.9)
        {
            TrangThai.setText("Thừa cân");
            nd.setTienTrinh(3);
            dao.updateNguoiDung(nd);
        }
        if(nd.getCanNang()/((nd.getCHieuCao()/100)*2) >25&&nd.getCanNang()/((nd.getCHieuCao()/100)*2)<29.9)
        {
            TrangThai.setText("Béo phì loại 1");
            nd.setTienTrinh(4);
            dao.updateNguoiDung(nd);
        }
        if(nd.getCanNang()/((nd.getCHieuCao()/100)*2) >=30)
        {
            TrangThai.setText("Béo phì loại 2");
            nd.setTienTrinh(5);
            dao.updateNguoiDung(nd);
        }

        Picasso.get().load(account.getPhotoUrl()).into(per_ima);
        person_name.setText(account.getDisplayName());
        btn_ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),SettingActivity.class);
                startActivity(in);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}