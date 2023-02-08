package com.example.test_dietapp1.ui.dashboard;

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

    private View viewCard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewCard = inflater.inflate(R.layout.fragment_card_food_notion, container, false);

        titleCard = (TextView) viewCard.findViewById(R.id.title);
        contentCard = (TextView) viewCard.findViewById(R.id.content);
        notionCard = (TextView) viewCard.findViewById(R.id.notion);

        Bundle bundleInfo = getArguments();
        if (bundleInfo != null) {
            CardInfo cardInfo = (CardInfo) bundleInfo.get("card_info_obj");
            if (cardInfo != null) {
                titleCard.setText(cardInfo.getTitle());
                contentCard.setText(cardInfo.getContent());
                notionCard.setText("Nhấn vào nút (+) góc trên bên phải để thêm mới món ăn yêu thích của riêng bạn");
            }
        }



        return viewCard;
    }
}
