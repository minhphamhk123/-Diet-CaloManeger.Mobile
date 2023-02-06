package com.example.test_dietapp1.module;

import android.media.Image;

public class MonAn {
    String MaMA;
    String TenMA;
    float SoCalo;
    byte[] HinhAnh;

    public MonAn() {
    }

    public MonAn(String maMA, String tenMA, float soCalo, byte[] hinhAnh) {
        MaMA = maMA;
        TenMA = tenMA;
        SoCalo = soCalo;
        HinhAnh = hinhAnh;
    }

    public String getMaMA() {
        return MaMA;
    }

    public void setMaMA(String maMA) {
        MaMA = maMA;
    }

    public String getTenMA() {
        return TenMA;
    }

    public void setTenMA(String tenMA) {
        TenMA = tenMA;
    }

    public float getSoCalo() {
        return SoCalo;
    }

    public void setSoCalo(float soCalo) {
        SoCalo = soCalo;
    }

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        HinhAnh = hinhAnh;
    }
}