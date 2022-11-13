package com.example.test_dietapp1.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Testadapter extends FragmentStateAdapter {
    public Testadapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment = new Fragmentadd();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(Fragmentadd.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
