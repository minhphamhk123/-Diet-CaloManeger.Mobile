package com.example.test_dietapp1.ui.homefood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test_dietapp1.R;

public class fragment_card_food_notion extends Fragment {

//    private String titleCard;
//    private String contentCard;
//    private String notionCard;
    private View viewCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewCard = inflater.inflate(R.layout.fragment_card_food_notion, container, false);

        return viewCard;
    }
}
