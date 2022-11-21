package com.example.test_dietapp1.ui.dashboard;

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
import com.example.test_dietapp1.databinding.FragmentDashboardBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DashboardFragment extends Fragment {

    private List<CardInfo> mListCardInfo;

    private FragmentDashboardBinding binding;
    private TabLayout optionTab;
    private SearchView searchView;
    private FloatingActionButton btnSearch;
    private FloatingActionButton btnAdd;
    private ViewPager2 fragmentViewCard;
    private Testadapter viewPagerAdapter;

    private View homeView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //binding = FragmentDashboardBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();
        super.onCreate(savedInstanceState);
        homeView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initUI(homeView);

        mListCardInfo = getListCardInfo();

        //Adapter Tablayout
        Testadapter adapter = new Testadapter(getParentFragmentManager(), getLifecycle(), mListCardInfo);
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

        return homeView;
    }

    private void initUI(View homeView) {
        searchView = (SearchView) homeView.findViewById(R.id.search_view_food);
        btnSearch = (FloatingActionButton) homeView.findViewById(R.id.btn_search);
        btnAdd = (FloatingActionButton) homeView.findViewById(R.id.btn_add);
        optionTab = (TabLayout) homeView.findViewById(R.id.tab_layout);
        fragmentViewCard = (ViewPager2) homeView.findViewById(R.id.view_pager);
    }

    private List<CardInfo> getListCardInfo() {
        List<CardInfo> list = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            list.add(new CardInfo(new String[] {"Tiêu đề " + (i+1), "Nội dung " + (i+1), "Lưu ý: " + (i+1)}));
        }
        return list;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}