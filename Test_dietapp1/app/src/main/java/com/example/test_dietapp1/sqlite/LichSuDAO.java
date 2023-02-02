package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.LichSu;
import com.example.test_dietapp1.module.MonAn;

import java.util.ArrayList;
import java.util.List;

public class LichSuDAO {
    private SQLiteDatabase db;

    public LichSuDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<LichSu> getLichSu(String sql, String ...selectAsrgs) {
        List<LichSu> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            LichSu LS = new LichSu();
            LS.setMaNK(cursor.getString(cursor.getColumnIndex("MaNK")));
            LS.setDate(cursor.getString(cursor.getColumnIndex("Date")));
            LS.setLuongNuocUong(cursor.getInt(cursor.getColumnIndex("LuongNuocUong")));
            LS.setLuongCalo(cursor.getInt(cursor.getColumnIndex("LuongCalo")));
            LS.setLuongCarbs(cursor.getInt(cursor.getColumnIndex("LuongCarbs")));
            LS.setLuongFat(cursor.getInt(cursor.getColumnIndex("LuongFat")));
            LS.setLuongProtein(cursor.getInt(cursor.getColumnIndex("LuongProtein")));
            list.add(LS);
        }
        return list;
    }
    public List<LichSu> getMonAnALL(){
        String sql = "SELECT * FROM LichSu";

        return getLichSu(sql);
    }
    public LichSu getByMaNK(String MaNK){
        String sql = "SELECT * FROM LichSu WHERE MaNK =?";

        List<LichSu> list = getLichSu(sql, MaNK);

        return list.get(0);
    }
    public long insertLichSu(LichSu LS) {
        ContentValues values = new ContentValues();
        values.put("MaMA", LS.getMaNK());
        values.put("TenMA", LS.getDate());
        values.put("SoCalo", LS.getLuongNuocUong());
        values.put("HinhAnh", LS.getLuongCalo());
        values.put("HinhAnh", LS.getLuongCarbs());
        values.put("HinhAnh", LS.getLuongFat());
        values.put("HinhAnh", LS.getLuongProtein());

        return db.insert("LichSu", null, values);
    }
    public long updateLichSu(LichSu LS) {
        ContentValues values = new ContentValues();
        values.put("MaMA", LS.getMaNK());
        values.put("TenMA", LS.getDate());
        values.put("SoCalo", LS.getLuongNuocUong());
        values.put("HinhAnh", LS.getLuongCalo());
        values.put("HinhAnh", LS.getLuongCarbs());
        values.put("HinhAnh", LS.getLuongFat());
        values.put("HinhAnh", LS.getLuongProtein());

        return db.update("LichSu", values, "MaNK =?", new String[]{LS.getMaNK()});
    }
    public long deleteLichSu(String MaNK) {
        return db.delete("LichSu", "MaNK =?", new String[]{MaNK});
    }
}
