package com.example.test_dietapp1.ui.homefood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.test_dietapp1.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeAddFoodFragment extends Fragment {

    private TabLayout optionTab;
    private SearchView searchView;
    private Button btnSearch;
    private Button btnAdd;
    private ViewPager2 fragmentViewCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        View homeView = inflater.inflate(R.layout.fragment_home_add_food, container, false);

        searchView = (SearchView) homeView.findViewById(R.id.search_view_food);
        btnSearch = (Button) homeView.findViewById(R.id.btn_search);
        btnAdd = (Button) homeView.findViewById(R.id.btn_add);
        optionTab = (TabLayout) homeView.findViewById(R.id.tab_layout);
        fragmentViewCard = (ViewPager2) homeView.findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        fragmentViewCard.setAdapter(adapter);

        new TabLayoutMediator(optionTab, fragmentViewCard, (tab, position) -> {
            switch (position) {
                case 0: {
                    tab.setText("Món ăn");
                    break;
                }
                case 1: {
                    tab.setText("Thực phẩm");
                    break;
                }
            }
        }).attach();

        return  homeView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
