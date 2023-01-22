package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.MonAn;
import com.example.test_dietapp1.module.QuanLy;

import java.util.ArrayList;
import java.util.List;

public class QuanLyDAO {
    private SQLiteDatabase db;

    public QuanLyDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<QuanLy> getQuanLy(String sql, String ...selectAsrgs) {
        List<QuanLy> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            QuanLy QL = new QuanLy();
            QL.setMaKH(cursor.getString(cursor.getColumnIndex("MaKH")));
            QL.setMaNK(cursor.getString(cursor.getColumnIndex("MaNK")));
            QL.setMaMA(cursor.getString(cursor.getColumnIndex("MaMA")));
            QL.setMaHD(cursor.getString(cursor.getColumnIndex("MaHD")));
            QL.setMaBT(cursor.getString(cursor.getColumnIndex("MaBT")));

            list.add(QL);
        }
        return list;
    }
    public List<QuanLy> getQuanLyALL(){
        String sql = "SELECT * FROM QuanLy";

        return getQuanLy(sql);
    }
    public QuanLy getByMaKH(String MaKH){
        String sql = "SELECT * FROM QuanLy WHERE MaKH =?";

        List<QuanLy> list = getQuanLy(sql, MaKH);

        return list.get(0);
    }
    public long insertQuanLy(QuanLy QL) {
        ContentValues values = new ContentValues();
        values.put("MaKH", QL.getMaKH());
        values.put("MaNK", QL.getMaNK());
        values.put("MaMA", QL.getMaMA());
        values.put("MaHD", QL.getMaHD());
        values.put("MaBT", QL.getMaBT());

        return db.insert("QuanLy", null, values);
    }
    public long updateQuanLy(QuanLy QL) {
        ContentValues values = new ContentValues();
        values.put("MaKH", QL.getMaKH());
        values.put("MaNK", QL.getMaNK());
        values.put("MaMA", QL.getMaMA());
        values.put("MaHD", QL.getMaHD());
        values.put("MaBT", QL.getMaBT());

        return db.update("QuanLy", values, "MaKH =?", new String[]{QL.getMaKH()});
    }
    public long deleteQuanLy(String MaKH) {
        return db.delete("QuanLy", "MaKH =?", new String[]{MaKH});
    }
}
