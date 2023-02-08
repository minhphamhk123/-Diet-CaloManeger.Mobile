package com.example.test_dietapp1.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class Testadapter extends FragmentStateAdapter {

    private List<CardInfo> mListCardInfo;
    public Testadapter(Fragment fragment,  List<CardInfo> list) {
        super(fragment);
        this.mListCardInfo = list;
    }

    public Testadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<CardInfo> list) {
        super(fragmentManager, lifecycle);
        this.mListCardInfo = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (mListCardInfo == null || mListCardInfo.isEmpty()) {
            return null;
        }

        CardInfo cardInfo = mListCardInfo.get(position);
        CardFoodNotionFragment cardInfoFrag = new CardFoodNotionFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("card_info_obj", cardInfo);
        cardInfoFrag.setArguments(bundle);

        return cardInfoFrag;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
