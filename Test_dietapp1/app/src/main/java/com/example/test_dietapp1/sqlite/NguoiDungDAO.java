package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private SQLiteDatabase db;

    public NguoiDungDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<NguoiDung> getNguoiDung(String sql, String ...selectAsrgs) {
        List<NguoiDung> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            NguoiDung nguoidung = new NguoiDung();
            nguoidung.setIDUser(cursor.getString(cursor.getColumnIndex("IDUser")));
            nguoidung.setTenKhachHang(cursor.getString(cursor.getColumnIndex("TenKhachHang")));
            nguoidung.setCanNang(cursor.getFloat(cursor.getColumnIndex("CanNang")));
            nguoidung.setCHieuCao(cursor.getFloat(cursor.getColumnIndex("ChieuCao")));
            nguoidung.setGioiTinh(cursor.getBlob(cursor.getColumnIndex("GioiTinh")));
            nguoidung.setTienTrinh(cursor.getInt(cursor.getColumnIndex("TienTrinh")));
            nguoidung.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            nguoidung.setSDT(cursor.getString(cursor.getColumnIndex("SDT")));
            nguoidung.setTuoi(cursor.getString(cursor.getColumnIndex("Tuoi")));

            list.add(nguoidung);
        }
        return list;
    }
    public List<NguoiDung> getNguoiDungALL(){
        String sql = "SELECT * FROM NguoiDung";

        return getNguoiDung(sql);
    }
    public NguoiDung getByMaMA(String MaMA){
        String sql = "SELECT * FROM NguoiDung WHERE IDUser =?";

        List<NguoiDung> list = getNguoiDung(sql, MaMA);

        return list.get(0);
    }
    public long insertNguoiDung(NguoiDung NguoiDung) {
        ContentValues values = new ContentValues();
        values.put("IDUser", NguoiDung.getIDUser());
        values.put("TenKhachHang", NguoiDung.getTenKhachHang());
        values.put("CanNang", NguoiDung.getCanNang());
        values.put("ChieuCao", NguoiDung.getCHieuCao());
        values.put("GioiTinh", NguoiDung.getGioiTinh());
        values.put("TienTrinh", NguoiDung.getTienTrinh());
        values.put("Email", NguoiDung.getEmail());
        values.put("SDT", NguoiDung.getEmail());
        values.put("Tuoi", NguoiDung.getTuoi());

        return db.insert("NguoiDung", null, values);
    }
    public long updateNguoiDung(NguoiDung NguoiDung) {
        ContentValues values = new ContentValues();
        values.put("IDUser", NguoiDung.getIDUser());
        values.put("TenKhachHang", NguoiDung.getTenKhachHang());
        values.put("CanNang", NguoiDung.getCanNang());
        values.put("ChieuCao", NguoiDung.getCHieuCao());
        values.put("GioiTinh", NguoiDung.getGioiTinh());
        values.put("TienTrinh", NguoiDung.getTienTrinh());
        values.put("Email", NguoiDung.getEmail());
        values.put("SDT", NguoiDung.getEmail());
        values.put("Tuoi", NguoiDung.getTuoi());

        return db.update("NguoiDung", values, "IDUser =?", new String[]{NguoiDung.getIDUser()});
    }
    public long deleteNguoiDung(String IDUser) {
        return db.delete("NguoiDung", "IDUser =?", new String[]{IDUser});
    }
}
