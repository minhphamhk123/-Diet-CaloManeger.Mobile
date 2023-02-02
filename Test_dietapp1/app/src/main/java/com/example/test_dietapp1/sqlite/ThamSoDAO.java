package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.test_dietapp1.module.ThamSo;

import java.util.ArrayList;
import java.util.List;

public class ThamSoDAO {
    private SQLiteDatabase db;

    public ThamSoDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<ThamSo> getThamSo(String sql, String ...selectAsrgs) {
        List<ThamSo> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            ThamSo TS = new ThamSo();
            TS.setLuongNuoc(cursor.getInt(cursor.getColumnIndex("LuongNuoc")));
            TS.setThoiGianLuyenTap(cursor.getInt(cursor.getColumnIndex("ThoiGianLuyenTap")));
            TS.setLuongNuocCoc(cursor.getInt(cursor.getColumnIndex("LuongNuocCoc")));
            list.add(TS);
        }
        return list;
    }
    public List<ThamSo> getThamSoALL(){
        String sql = "SELECT * FROM ThamSo";

        return getThamSo(sql);
    }

    public long insertThamSo(ThamSo ThamSo) {
        ContentValues values = new ContentValues();
        values.put("MaMA", ThamSo.getLuongNuoc());
        values.put("TenMA", ThamSo.getThoiGianLuyenTap());
        values.put("SoCalo", ThamSo.getLuongNuocCoc());

        return db.insert("MonAn", null, values);
    }
}
