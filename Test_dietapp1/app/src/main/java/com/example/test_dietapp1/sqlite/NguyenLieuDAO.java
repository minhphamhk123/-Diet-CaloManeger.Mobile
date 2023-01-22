package com.example.test_dietapp1.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.MonAn;
import com.example.test_dietapp1.module.NguyenLieu;

import java.util.ArrayList;
import java.util.List;

public class NguyenLieuDAO {
    private SQLiteDatabase db;

    public NguyenLieuDAO(Context context) {
        DatabaseHandler dbHandler = new DatabaseHandler(context);

        db = dbHandler.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<NguyenLieu> getNguyenLieu(String sql, String ...selectAsrgs) {
        List<NguyenLieu> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectAsrgs);

        while (cursor.moveToNext()) {
            NguyenLieu NL = new NguyenLieu();
            NL.setMaMA(cursor.getString(cursor.getColumnIndex("MaMA")));
            NL.setTenMA(cursor.getString(cursor.getColumnIndex("TenMA")));
            NL.setSoCalo(cursor.getFloat(cursor.getColumnIndex("SoCalo")));
            NL.setHinhAnh(cursor.getString(cursor.getColumnIndex("HinhAnh")));
            list.add(NL);
        }
        return list;
    }
    public List<NguyenLieu> getNguyenLieuALL(){
        String sql = "SELECT * FROM NguyenLieu";

        return getNguyenLieu(sql);
    }
    public NguyenLieu getByMaNL(String MaNL){
        String sql = "SELECT * FROM NguyenLieu WHERE MaNL =?";

        List<NguyenLieu> list = getNguyenLieu(sql, MaNL);

        return list.get(0);
    }
    public long insertNguyenLieu(NguyenLieu NL) {
        ContentValues values = new ContentValues();
        values.put("MaNL", NL.getMaNL());
        values.put("TenNL", NL.getTenNL());
        values.put("SoCalo", NL.getSoCalo());
        values.put("Carbs", NL.getCarbs());
        values.put("ChatDam", NL.getChatDam());
        values.put("ChatBeo", NL.getChatBeo());
        values.put("HinhAnh", NL.getHinhAnh());

        return db.insert("NguyenLieu", null, values);
    }
    public long updateNguyenLieu(NguyenLieu NL) {
        ContentValues values = new ContentValues();
        values.put("MaNL", NL.getMaNL());
        values.put("TenNL", NL.getTenNL());
        values.put("SoCalo", NL.getSoCalo());
        values.put("Carbs", NL.getCarbs());
        values.put("ChatDam", NL.getChatDam());
        values.put("ChatBeo", NL.getChatBeo());
        values.put("HinhAnh", NL.getHinhAnh());

        return db.update("NguyenLieu", values, "MaNL =?", new String[]{NL.getMaNL()});
    }
    public long deleteNguyenLieu(String MaNL) {
        return db.delete("NguyenLieu", "MaNL =?", new String[]{MaNL});
    }
}
