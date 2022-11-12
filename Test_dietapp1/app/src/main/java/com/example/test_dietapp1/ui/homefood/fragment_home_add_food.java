package com.example.test_dietapp1.ui.homefood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.test_dietapp1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class fragment_home_add_food extends Fragment {

    private TabLayout optionTab;
    private ViewPager2 fragmentViewCard;
    private view_pager_adapter viewPagerAdapter;
    private View homeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home_add_food, container, false);

        optionTab = homeView.findViewById(R.id.tab_layout);
        fragmentViewCard = homeView.findViewById(R.id.view_pager);

        view_pager_adapter adapter = new view_pager_adapter(this);
        fragmentViewCard.setAdapter(adapter);

        new TabLayoutMediator(optionTab, fragmentViewCard, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Món ăn");
                    break;
                case 1:
                    tab.setText("Thực phẩm");
                    break;
            }
        }).attach();

        return  homeView;
    }
}
