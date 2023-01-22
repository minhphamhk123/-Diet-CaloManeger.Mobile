package com.example.test_dietapp1.module;

public class BaiTap {
    String MaBT;
    String TenBT;
    int ThoiLuong;
    int CaloTime;

    public BaiTap() {
    }

    public BaiTap(String maBT, String tenBT, int thoiLuong, int caloTime) {
        MaBT = maBT;
        TenBT = tenBT;
        ThoiLuong = thoiLuong;
        CaloTime = caloTime;
    }

    public String getMaBT() {
        return MaBT;
    }

    public void setMaBT(String maBT) {
        MaBT = maBT;
    }

    public String getTenBT() {
        return TenBT;
    }

    public void setTenBT(String tenBT) {
        TenBT = tenBT;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        ThoiLuong = thoiLuong;
    }

    public int getCaloTime() {
        return CaloTime;
    }

    public void setCaloTime(int caloTime) {
        CaloTime = caloTime;
    }
}
