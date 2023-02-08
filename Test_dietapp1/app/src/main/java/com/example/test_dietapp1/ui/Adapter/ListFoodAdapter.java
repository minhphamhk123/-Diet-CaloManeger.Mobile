package com.example.test_dietapp1.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.test_dietapp1.R;

import com.example.test_dietapp1.module.MonAn;
import java.util.List;

public class ListFoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonAn> listMonAn;

    public ListFoodAdapter(Context context, int layout,  List<MonAn> list){
        this.context = context;
        this.layout = layout;
        this.listMonAn = list;
    }

    @Override
    public int getCount() {
        return listMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        // ánh xạ view
        TextView txt_title = (TextView) view.findViewById(R.id.text_title);
        TextView txt_calo = (TextView) view.findViewById(R.id.text_calo);

        // gán giá trị
        MonAn monAn = listMonAn.get(i);
        txt_title.setText(monAn.getTenMA());
        txt_calo.setText(Float.toString(monAn.getSoCalo()));
        return null;
    }
}
