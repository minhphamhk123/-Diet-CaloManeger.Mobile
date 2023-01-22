package com.example.test_dietapp1.module;

public class ThamSo {
    int LuongNuoc;
    int ThoiGianLuyenTap;
    int LuongNuocCoc;

    public ThamSo() {
    }

    public ThamSo(int luongNuoc, int thoiGianLuyenTap, int luongNuocCoc) {
        LuongNuoc = luongNuoc;
        ThoiGianLuyenTap = thoiGianLuyenTap;
        LuongNuocCoc = luongNuocCoc;
    }

    public int getLuongNuoc() {
        return LuongNuoc;
    }

    public void setLuongNuoc(int luongNuoc) {
        LuongNuoc = luongNuoc;
    }

    public int getThoiGianLuyenTap() {
        return ThoiGianLuyenTap;
    }

    public void setThoiGianLuyenTap(int thoiGianLuyenTap) {
        ThoiGianLuyenTap = thoiGianLuyenTap;
    }

    public int getLuongNuocCoc() {
        return LuongNuocCoc;
    }

    public void setLuongNuocCoc(int luongNuocCoc) {
        LuongNuocCoc = luongNuocCoc;
    }
}
