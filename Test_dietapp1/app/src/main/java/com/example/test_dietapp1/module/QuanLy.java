package com.example.test_dietapp1.module;

public class QuanLy {
    String MaKH;
    String MaNK;
    String MaMA;
    String MaHD;
    String MaBT;

    public QuanLy() {
    }

    public QuanLy(String maKH, String maNK, String maMA, String maHD, String maBT) {
        MaKH = maKH;
        MaNK = maNK;
        MaMA = maMA;
        MaHD = maHD;
        MaBT = maBT;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getMaNK() {
        return MaNK;
    }

    public void setMaNK(String maNK) {
        MaNK = maNK;
    }

    public String getMaMA() {
        return MaMA;
    }

    public void setMaMA(String maMA) {
        MaMA = maMA;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getMaBT() {
        return MaBT;
    }

    public void setMaBT(String maBT) {
        MaBT = maBT;
    }
}
