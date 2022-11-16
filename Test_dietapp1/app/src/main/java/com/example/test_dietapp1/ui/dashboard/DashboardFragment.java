package com.example.test_dietapp1.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.databinding.FragmentDashboardBinding;
import com.example.test_dietapp1.ui.homefood.view_pager_adapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private TabLayout optionTab;
    private ViewPager2 fragmentViewCard;
    private view_pager_adapter viewPagerAdapter;
    private View homeView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //binding = FragmentDashboardBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();
        homeView = inflater.inflate(R.layout.fragment_dashboard, container, false);

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
        //return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}