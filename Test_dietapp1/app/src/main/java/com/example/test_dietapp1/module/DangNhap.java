package com.example.test_dietapp1.module;

public class DangNhap {
    String ID;
    String TenDN;
    String MK;

    public DangNhap() {
    }

    public DangNhap(String ID, String tenDN, String MK) {
        this.ID = ID;
        TenDN = tenDN;
        this.MK = MK;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String tenDN) {
        TenDN = tenDN;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }
}
