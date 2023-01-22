package com.example.test_dietapp1.module;

public class NguoiDung {
    String IDUser;
    String TenKhachHang;
    float CanNang;
    float CHieuCao;
    Boolean GioiTinh;
    int TienTrinh;
    String Email;
    String SDT;
    String Tuoi;

    public NguoiDung() {
    }

    public NguoiDung(String IDUser, String tenKhachHang, float canNang, float CHieuCao, Boolean gioiTinh, int tienTrinh, String email, String SDT, String tuoi) {
        this.IDUser = IDUser;
        TenKhachHang = tenKhachHang;
        CanNang = canNang;
        this.CHieuCao = CHieuCao;
        GioiTinh = gioiTinh;
        TienTrinh = tienTrinh;
        Email = email;
        this.SDT = SDT;
        Tuoi = tuoi;
    }

    public String getIDUser() {
        return IDUser;
    }

    public void setIDUser(String IDUser) {
        this.IDUser = IDUser;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        TenKhachHang = tenKhachHang;
    }

    public float getCanNang() {
        return CanNang;
    }

    public void setCanNang(float canNang) {
        CanNang = canNang;
    }

    public float getCHieuCao() {
        return CHieuCao;
    }

    public void setCHieuCao(float CHieuCao) {
        this.CHieuCao = CHieuCao;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getTienTrinh() {
        return TienTrinh;
    }

    public void setTienTrinh(int tienTrinh) {
        TienTrinh = tienTrinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String tuoi) {
        Tuoi = tuoi;
    }
}
