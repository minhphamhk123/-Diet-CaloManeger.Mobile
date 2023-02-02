package com.example.test_dietapp1.module;

public class Cook {
    String MaMA;
    String MaNL;

    public Cook() {
    }

    public Cook(String maMA, String maNL) {
        MaMA = maMA;
        MaNL = maNL;
    }

    public String getMaMA() {
        return MaMA;
    }

    public void setMaMA(String maMA) {
        MaMA = maMA;
    }

    public String getMaNL() {
        return MaNL;
    }

    public void setMaNL(String maNL) {
        MaNL = maNL;
    }
}
