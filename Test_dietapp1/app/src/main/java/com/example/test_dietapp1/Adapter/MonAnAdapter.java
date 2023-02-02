package com.example.test_dietapp1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.MonAn;

import java.util.List;

public class MonAnAdapter extends BaseAdapter {
private Context context;
private List<MonAn> list;

    public MonAnAdapter(Context context, List<MonAn> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fragment_eat_schedule_,null);
        }

        //TextView TenMA = view.findViewById(R.id.t);
        return null;
    }
}
