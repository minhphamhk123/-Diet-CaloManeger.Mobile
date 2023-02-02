package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.DangNhap;

import java.util.ArrayList;
import java.util.List;

public class DangNhapDAO {
    private SQLiteDatabase db;

    public DangNhapDAO(Context context) {
        DatabaseHandler handler = new DatabaseHandler(context);

        db = handler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<DangNhap> getDangNhap(String sql, String ...selectAsrgs) {
        List<DangNhap> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            DangNhap DN = new DangNhap();
            DN.setID(cursor.getString(cursor.getColumnIndex("ID")));
            DN.setTenDN(cursor.getString(cursor.getColumnIndex("TenDN")));
            DN.setMK(cursor.getString(cursor.getColumnIndex("MK")));
            list.add(DN);
        }
        return list;
    }
    public List<DangNhap> getDangNhapALL(){
        String sql = "SELECT * FROM DangNhap";

        return getDangNhap(sql);
    }
    public DangNhap getByID(String ID){
        String sql = "SELECT * FROM DangNhap WHERE ID =?";

        List<DangNhap> list = getDangNhap(sql, ID);

        return list.get(0);
    }
    public long insertDangNhap(DangNhap DN) {
        ContentValues values = new ContentValues();
        values.put("ID", DN.getID());
        values.put("TenDN", DN.getTenDN());
        values.put("MK", DN.getMK());

        return db.insert("DangNhap", null, values);
    }
    public long updateDangNhap(DangNhap DN) {
        ContentValues values = new ContentValues();
        values.put("ID", DN.getID());
        values.put("TenDN", DN.getTenDN());
        values.put("MK", DN.getMK());

        return db.update("DangNhap", values, "ID =?", new String[]{DN.getID()});
    }
    public long deleteCook(String ID) {
        return db.delete("DangNhap", "ID =?", new String[]{ID});
    }
}
