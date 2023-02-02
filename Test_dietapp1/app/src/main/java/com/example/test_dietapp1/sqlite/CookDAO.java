package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.Cook;

import java.util.ArrayList;
import java.util.List;

public class CookDAO {
    private SQLiteDatabase db;

    public CookDAO(Context context) {
        DatabaseHandler handler = new DatabaseHandler(context);

        db = handler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Cook> getCook(String sql, String ...selectAsrgs) {
        List<Cook> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            Cook cook = new Cook();
            cook.setMaMA(cursor.getString(cursor.getColumnIndex("MaMA")));
            cook.setMaNL(cursor.getString(cursor.getColumnIndex("MaNL")));
            list.add(cook);
        }
        return list;
    }
    public List<Cook> getCookALL(){
        String sql = "SELECT * FROM Cook";

        return getCook(sql);
    }
    public Cook getByMaMA(String MaMA){
        String sql = "SELECT * FROM Cook WHERE MaMA =?";

        List<Cook> list = getCook(sql, MaMA);

        return list.get(0);
    }
    public long insertCook(Cook cook) {
        ContentValues values = new ContentValues();
        values.put("MaBT", cook.getMaMA());
        values.put("TenBT", cook.getMaNL());

        return db.insert("Cook", null, values);
    }
    public long updateCook(Cook cook) {
        ContentValues values = new ContentValues();
        values.put("MaBT", cook.getMaMA());
        values.put("TenBT", cook.getMaNL());

        return db.update("Cook", values, "MaMA =?", new String[]{cook.getMaMA()});
    }
    public long deleteCook(String MaMA) {
        return db.delete("Cook", "MaMA =?", new String[]{MaMA});
    }
}
