package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.MonAn;

import java.util.ArrayList;
import java.util.List;

public class MonAnDAO {
    private SQLiteDatabase db;

    public MonAnDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public  List<MonAn> getMonAn(String sql, String ...selectAsrgs) {
        List<MonAn> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            MonAn monAn = new MonAn();
            monAn.setMaMA(cursor.getString(cursor.getColumnIndex("MaMA")));
            monAn.setTenMA(cursor.getString(cursor.getColumnIndex("TenMA")));
            monAn.setSoCalo(cursor.getFloat(cursor.getColumnIndex("SoCalo")));
            monAn.setHinhAnh(cursor.getString(cursor.getColumnIndex("HinhAnh")));
            list.add(monAn);
        }
        return list;
    }
    public List<MonAn> getMonAnALL(){
        String sql = "SELECT * FROM MonAn";

        return getMonAn(sql);
    }
    public MonAn getByMaMA(String MaMA){
        String sql = "SELECT * FROM MonAn WHERE MaMA =?";

        List<MonAn> list = getMonAn(sql, MaMA);

        return list.get(0);
    }
    public long insertMonAn(MonAn MonAn) {
        ContentValues values = new ContentValues();
        values.put("MaMA", MonAn.getMaMA());
        values.put("TenMA", MonAn.getTenMA());
        values.put("SoCalo", MonAn.getSoCalo());
        values.put("HinhAnh", MonAn.getHinhAnh());

        return db.insert("MonAn", null, values);
    }
    public long updateMonAn(MonAn MonAn) {
        ContentValues values = new ContentValues();
        values.put("MaMA", MonAn.getMaMA());
        values.put("TenMA", MonAn.getTenMA());
        values.put("SoCalo", MonAn.getSoCalo());
        values.put("HinhAnh", MonAn.getHinhAnh());

        return db.update("MonAn", values, "MaMA =?", new String[]{MonAn.getMaMA()});
    }
    public long deleteMonAn(String MaMA) {
        return db.delete("MonAn", "MaMA =?", new String[]{MaMA});
    }
}
