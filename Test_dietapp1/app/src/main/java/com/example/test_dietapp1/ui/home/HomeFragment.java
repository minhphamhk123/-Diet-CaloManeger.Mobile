package com.example.test_dietapp1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test_dietapp1.databinding.FragmentHomeBinding;
import com.example.test_dietapp1.module.NguoiDung;
import com.example.test_dietapp1.sqlite.DangNhapDAO;
import com.example.test_dietapp1.sqlite.NguoiDungDAO;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NguoiDungDAO nd = new NguoiDungDAO(root.getContext());
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(root.getContext());

        NguoiDung newNgD = nd.getByMaMA(account.getId());
        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}