package com.example.test_dietapp1.module;

import java.util.Date;

public class LichSu {
    String MaNK;
    String date;
    int LuongNuocUong;
    int LuongCalo;
    int LuongCarbs;
    int LuongProtein;
    int LuongFat;

    public LichSu() {
    }

    public LichSu(String maNK, String date, int luongNuocUong, int luongCalo, int luongCarbs, int luongProtein, int luongFat) {
        MaNK = maNK;
        this.date = date;
        LuongNuocUong = luongNuocUong;
        LuongCalo = luongCalo;
        LuongCarbs = luongCarbs;
        LuongProtein = luongProtein;
        LuongFat = luongFat;
    }

    public String getMaNK() {
        return MaNK;
    }

    public void setMaNK(String maNK) {
        MaNK = maNK;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLuongNuocUong() {
        return LuongNuocUong;
    }

    public void setLuongNuocUong(int luongNuocUong) {
        LuongNuocUong = luongNuocUong;
    }

    public int getLuongCalo() {
        return LuongCalo;
    }

    public void setLuongCalo(int luongCalo) {
        LuongCalo = luongCalo;
    }

    public int getLuongCarbs() {
        return LuongCarbs;
    }

    public void setLuongCarbs(int luongCarbs) {
        LuongCarbs = luongCarbs;
    }

    public int getLuongProtein() {
        return LuongProtein;
    }

    public void setLuongProtein(int luongProtein) {
        LuongProtein = luongProtein;
    }

    public int getLuongFat() {
        return LuongFat;
    }

    public void setLuongFat(int luongFat) {
        LuongFat = luongFat;
    }
}
