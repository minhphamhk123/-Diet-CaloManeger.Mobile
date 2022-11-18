package com.example.test_dietapp1.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.test_dietapp1.ui.homefood.fragment_card_food_notion;
import com.example.test_dietapp1.ui.homefood.fragment_home_add_food;

public class Testadapter extends FragmentStateAdapter {
    public Testadapter(@androidx.annotation.NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new fragment_card_food_notion();
            case 1:
                return new fragment_card_food_notion();
            default:
                return  new fragment_home_add_food();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
