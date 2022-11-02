package com.example.test_dietapp1.ui.homefood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class view_pager_adapter extends FragmentStateAdapter {

    public view_pager_adapter(@NonNull Fragment fragment) {
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
