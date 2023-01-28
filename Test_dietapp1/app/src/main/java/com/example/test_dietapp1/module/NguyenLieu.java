package com.example.test_dietapp1.module;

import android.media.Image;

public class NguyenLieu {
    String MaNL;
    String TenNL;
    float SoCalo;
    float Carbs;
    float ChatDam;
    float ChatBeo;
    byte[] HinhAnh;

    public NguyenLieu() {
    }

    public NguyenLieu(String maNL, String tenNL, float soCalo, float carbs, float chatDam, float chatBeo, byte[] hinhAnh) {
        MaNL = maNL;
        TenNL = tenNL;
        SoCalo = soCalo;
        Carbs = carbs;
        ChatDam = chatDam;
        ChatBeo = chatBeo;
        HinhAnh = hinhAnh;
    }

    public String getMaNL() {
        return MaNL;
    }

    public void setMaNL(String maNL) {
        MaNL = maNL;
    }

    public String getTenNL() {
        return TenNL;
    }

    public void setTenNL(String tenNL) {
        TenNL = tenNL;
    }

    public float getSoCalo() {
        return SoCalo;
    }

    public void setSoCalo(float soCalo) {
        SoCalo = soCalo;
    }

    public float getCarbs() {
        return Carbs;
    }

    public void setCarbs(float carbs) {
        Carbs = carbs;
    }

    public float getChatDam() {
        return ChatDam;
    }

    public void setChatDam(float chatDam) {
        ChatDam = chatDam;
    }

    public float getChatBeo() {
        return ChatBeo;
    }

    public void setChatBeo(float chatBeo) {
        ChatBeo = chatBeo;
    }

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        HinhAnh = hinhAnh;
    }
}
