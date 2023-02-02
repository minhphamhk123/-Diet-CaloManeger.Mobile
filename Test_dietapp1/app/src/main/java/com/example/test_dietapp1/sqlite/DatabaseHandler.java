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
    public static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "Caculate";

    public static final String CACULATE_BMR = "BMR";
    public static final String CACULATE_R = "R";
    public static final String CACULATE_TDEE = "TDEE";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_caculate_table = String.format("CREATE TABLE %s(%s REAL, %s REAL, %s REAL)","Caculate","BMR","R","TDEE");
        String create_monan_table = "CREATE TABLE MonAn(MaMA TEXT PRIMARY KEY, TenMA TEXT, SoCalo REAL, HinhAnh BLOB)";
        String create_nguyenlieu_table = "CREATE TABLE NguyenLieu(MaNL TEXT PRIMARY KEY, TenNL TEXT, SoCalo REAL, Carbs REAL, ChatDam REAL, ChatBeo REAL, HinhAnh BLOB)";
        String create_baitap_table = "CREATE TABLE BaiTap(MaBT TEXT PRIMARY KEY, TenBT TEXT, ThoiLuong INTEGER, CaloTime INTEGER)";
        String create_hoatdong_table = "CREATE TABLE HoatDong(MaHD TEXT PRIMARY KEY, TenHD TEXT, ThoiGian INTEGER, CaloTime INTEGER)";
        String create_thamso_table = "CREATE TABLE ThamSo(LuongNuoc INTEGER, ThoiGianLuyenTap INTEGER, LuongNuocCoc INTEGER)";
        String create_lichsu_table = "CREATE TABLE LichSu(MaNK TEXT PRIMARY KEY, Date TEXT, LuongNuocUong INTEGER, LuongCalo INTEGER, LuongCarbs INTEGER, LuongProtein INTEGER, LuongFat INTEGER)";
        String create_dangnhap_table = "CREATE TABLE DangNhap(ID TEXT PRIMARY KEY, TenDN TEXT, MK TEXT)";

        String create_nguoidung_table = "CREATE TABLE NguoiDung(" +
                "IDUser TEXT PRIMARY KEY, " +
                "TenKhachHang TEXT, " +
                "CanNang REAL, " +
                "ChieuCao REAL, " +
                "GioiTinh INTEGER, " +
                "TienTrinh INTEGER, " +
                "Email TEXT, " +
                "SDT TEXT, " +
                "Tuoi TEXT, " +
                "FOREIGN KEY (IDUser) REFERENCES DangNhap(ID))";
        String create_quanly_table = String.format("CREATE TABLE QuanLy(" +
                "MaKH TEXT PRIMARY KEY, " +
                "MaNK TEXT, " +
                "MaMA TEXT, " +
                "MaHD TEXT, " +
                "MaBT TEXT, " +
                "FOREIGN KEY (MaKH) REFERENCES KhachHang(IDUser), " +
                "FOREIGN KEY (MaNK) REFERENCES LichSu(MaNK), " +
                "FOREIGN KEY (MaMA) REFERENCES Cook(MaMA), " +
                "FOREIGN KEY (MaHD) REFERENCES HoatDong(MaHD), " +
                "FOREIGN KEY (MaBT) REFERENCES BaiTap(MaBT))");

        String create_cook_table = String.format("CREATE TABLE Cook(" +
                "MaMA TEXT NOT NULL, " +
                "MaNL TEXT NOT NULL, " +
                //"CONSTRAINT PK_Cook
                "PRIMARY KEY (MaMA, MaNL), " +
                "FOREIGN KEY (MaMA) REFERENCES MonAn(MaMA), " +
                "FOREIGN KEY (MaNL) REFERENCES NguyenLieu(MaNL))");
        sqLiteDatabase.execSQL(create_caculate_table);
        sqLiteDatabase.execSQL(create_monan_table);
        sqLiteDatabase.execSQL(create_nguyenlieu_table);
        sqLiteDatabase.execSQL(create_baitap_table);
        sqLiteDatabase.execSQL(create_hoatdong_table);
        sqLiteDatabase.execSQL(create_thamso_table);
        sqLiteDatabase.execSQL(create_lichsu_table);
        sqLiteDatabase.execSQL(create_dangnhap_table);

        sqLiteDatabase.execSQL(create_nguoidung_table);
        sqLiteDatabase.execSQL(create_cook_table);
        sqLiteDatabase.execSQL(create_quanly_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_caculate_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        String drop_monan_table = String.format("DROP TABLE IF EXISTS %s", "MonAn");
        String drop_nguyenlieu_table = String.format("DROP TABLE IF EXISTS %s", "NguyenLieu");
        String drop_baitap_table = String.format("DROP TABLE IF EXISTS %s", "BaiTap");
        String drop_hoatdong_table = String.format("DROP TABLE IF EXISTS %s", "HoatDong");
        String drop_thamso_table = String.format("DROP TABLE IF EXISTS %s", "ThamSo");
        String drop_lichsu_table = String.format("DROP TABLE IF EXISTS %s", "LichSu");
        String drop_dangnhap_table = String.format("DROP TABLE IF EXISTS %s", "DangNhap");
        String drop_cook_table = String.format("DROP TABLE IF EXISTS %s", "Cook");
        String drop_nguoidung_table = String.format("DROP TABLE IF EXISTS %s", "NguoiDung");
        String drop_quanly_table = String.format("DROP TABLE IF EXISTS %s", "QuanLy");

        sqLiteDatabase.execSQL(drop_caculate_table);
        sqLiteDatabase.execSQL(drop_monan_table);
        sqLiteDatabase.execSQL(drop_nguyenlieu_table);
        sqLiteDatabase.execSQL(drop_baitap_table);
        sqLiteDatabase.execSQL(drop_hoatdong_table);
        sqLiteDatabase.execSQL(drop_thamso_table);
        sqLiteDatabase.execSQL(drop_lichsu_table);
        sqLiteDatabase.execSQL(drop_dangnhap_table);
        sqLiteDatabase.execSQL(drop_cook_table);
        sqLiteDatabase.execSQL(drop_nguoidung_table);
        sqLiteDatabase.execSQL(drop_quanly_table);

        onCreate(sqLiteDatabase);
    }
}
