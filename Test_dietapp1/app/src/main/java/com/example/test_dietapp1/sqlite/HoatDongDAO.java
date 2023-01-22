package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.DangNhap;
import com.example.test_dietapp1.module.HoatDong;

import java.util.ArrayList;
import java.util.List;

public class HoatDongDAO {
    private SQLiteDatabase db;

    public HoatDongDAO(Context context) {
        DatabaseHandler handler = new DatabaseHandler(context);

        db = handler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<HoatDong> getHoatDong(String sql, String ...selectAsrgs) {
        List<HoatDong> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            HoatDong HD = new HoatDong();
            HD.setMaHD(cursor.getString(cursor.getColumnIndex("MaHD")));
            HD.setTenHD(cursor.getString(cursor.getColumnIndex("TenHD")));
            HD.setCaloTime(cursor.getInt(cursor.getColumnIndex("CaloTime")));
            HD.setThoiGian(cursor.getInt(cursor.getColumnIndex("ThoiGian")));
            list.add(HD);
        }
        return list;
    }
    public List<HoatDong> getHoatDongALL(){
        String sql = "SELECT * FROM HoatDong";

        return getHoatDong(sql);
    }
    public HoatDong getByID(String MaHD){
        String sql = "SELECT * FROM HoatDong WHERE MaHD =?";

        List<HoatDong> list = getHoatDong(sql, MaHD);

        return list.get(0);
    }
    public long insertHoatDong(HoatDong HD) {
        ContentValues values = new ContentValues();
        values.put("MaHD", HD.getMaHD());
        values.put("TenDN", HD.getTenHD());
        values.put("CaloTme",HD.getCaloTime());
        values.put("ThoiGian",HD.getThoiGian());

        return db.insert("HoatDong", null, values);
    }
    public long updateHoatDong(HoatDong HD) {
        ContentValues values = new ContentValues();
        values.put("MaHD", HD.getMaHD());
        values.put("TenDN", HD.getTenHD());
        values.put("CaloTme",HD.getCaloTime());
        values.put("ThoiGian",HD.getThoiGian());

        return db.update("HoatDong", values, "MaHD =?", new String[]{HD.getMaHD()});
    }
    public long deleteCook(String MaHD) {
        return db.delete("HoatDong", "MaHD =?", new String[]{MaHD});
    }
}
