package com.example.test_dietapp1.ui.homefood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test_dietapp1.R;

public class CardFoodNotionFragment extends Fragment {

    private TextView titleCard;
    private TextView contentCard;
    private TextView notionCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_card_food_notion, container, false);

        titleCard = v.findViewById(R.id.title);
        contentCard = v.findViewById(R.id.content);
        notionCard = v.findViewById(R.id.notion);

        return v;
    }
}
