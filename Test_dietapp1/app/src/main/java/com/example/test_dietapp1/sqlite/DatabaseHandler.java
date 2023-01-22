package com.example.test_dietapp1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test_dietapp1.module.Caculate;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "APP_CALO";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Caculate";

    public static final String CACULATE_BMR = "BMR";
    public static final String CACULATE_R = "R";
    public static final String CACULATE_TDEE = "TDEE";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_caculate_table = String.format("CREATE TABLE %s(%s REAL, %s REAL, %s REAL)",TABLE_NAME,CACULATE_BMR,CACULATE_R,CACULATE_TDEE);
        sqLiteDatabase.execSQL(create_caculate_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_caculate_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(drop_caculate_table);

        onCreate(sqLiteDatabase);
    }

    /*public void deleteCaculate(Caculate caculate)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,CACULATE_BMR + "=?",new String[] {String.valueOf(caculate.getBMR())});
        db.close();
    }*/
}
