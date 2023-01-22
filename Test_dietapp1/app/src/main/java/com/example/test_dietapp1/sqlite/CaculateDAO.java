package com.example.test_dietapp1.sqlite;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.test_dietapp1.module.Caculate;

import java.util.ArrayList;
import java.util.List;

public class CaculateDAO {
    private SQLiteDatabase db;

    public CaculateDAO(Context context) {
        DatabaseHandler databaseHelper = new DatabaseHandler(context);
        db = databaseHelper.getWritableDatabase();
    }

    public List<Caculate> getCaculates(String sql, String... selectionArgs) {
        List<Caculate> caculateList = new ArrayList<Caculate>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Caculate caculate = new Caculate(cursor.getFloat(0), cursor.getFloat(1), cursor.getFloat(2));
            caculateList.add(caculate);
        }
        return caculateList;
    }

    public List<Caculate> getCaculatesAll() {
        String sql = "SELECT * FROM Caculate ";
        return getCaculates(sql);
    }

    public long insertCaculate(Caculate caculate) {
        ContentValues values = new ContentValues();
        values.put("BMR", caculate.getBMR());
        values.put("R", caculate.getR());
        values.put("TDEE", caculate.getTDEE());
        return db.insert("Caculate", null, values);
    }

    /*public long updateCaculate(Caculate caculate) {
        ContentValues values = new ContentValues();
        values.put("BMR", caculate.getBMR());
        values.put("R", caculate.getR());
        values.put("TDEE", caculate.getTDEE());

        return db.update("Caculate", values, "BMR =?", new String[]{caculate.getBMR().toString()});
    }*/
}
