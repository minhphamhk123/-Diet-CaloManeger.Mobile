package com.example.test_dietapp1.module;

public class HoatDong {
    String MaHD;
    String TenHD;
    int ThoiGian;
    int CaloTime;

    public HoatDong() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getTenHD() {
        return TenHD;
    }

    public void setTenHD(String tenHD) {
        TenHD = tenHD;
    }

    public int getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(int thoiGian) {
        ThoiGian = thoiGian;
    }

    public int getCaloTime() {
        return CaloTime;
    }

    public void setCaloTime(int caloTime) {
        CaloTime = caloTime;
    }

    public HoatDong(String maHD, String tenHD, int thoiGian, int caloTime) {
        MaHD = maHD;
        TenHD = tenHD;
        ThoiGian = thoiGian;
        CaloTime = caloTime;
    }
}
