package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.BaiTap;

import java.util.ArrayList;
import java.util.List;

public class BaiTapDAO {
    private SQLiteDatabase db;

    public BaiTapDAO(Context context) {
        DatabaseHandler handler = new DatabaseHandler(context);

        db = handler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<BaiTap> getBaiTap(String sql, String ...selectAsrgs) {
        List<BaiTap> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            BaiTap baiTap = new BaiTap();
            baiTap.setMaBT(cursor.getString(cursor.getColumnIndex("MaBT")));
            baiTap.setTenBT(cursor.getString(cursor.getColumnIndex("TenBT")));
            baiTap.setCaloTime(cursor.getInt(cursor.getColumnIndex("CaloTime")));
            baiTap.setThoiLuong(cursor.getInt(cursor.getColumnIndex("ThoiLuong")));
            list.add(baiTap);
        }
        return list;
    }
    public List<BaiTap> getBaiTapALL(){
        String sql = "SELECT * FROM BaiTap";

        return getBaiTap(sql);
    }
    public BaiTap getByMaBT(String MaBT){
        String sql = "SELECT * FROM BaiTap WHERE MaBT =?";

        List<BaiTap> list = getBaiTap(sql, MaBT);

        return list.get(0);
    }
    public long insertBaiTap(BaiTap BaiTap) {
        ContentValues values = new ContentValues();
        values.put("MaBT", BaiTap.getMaBT());
        values.put("TenBT", BaiTap.getTenBT());
        values.put("CaloTime", BaiTap.getCaloTime());
        values.put("ThoiLuong", BaiTap.getThoiLuong());

        return db.insert("BaiTap", null, values);
    }
    public long updateBaiTap(BaiTap BaiTap) {
        ContentValues values = new ContentValues();
        values.put("MaBT", BaiTap.getMaBT());
        values.put("TenBT", BaiTap.getTenBT());
        values.put("CaloTime", BaiTap.getCaloTime());
        values.put("ThoiLuong", BaiTap.getThoiLuong());

        return db.update("BaiTap", values, "MaBT =?", new String[]{BaiTap.getMaBT()});
    }
    public long deleteBaiTap(String MaBT) {
        return db.delete("BaiTap", "MaBT =?", new String[]{MaBT});
    }
}
