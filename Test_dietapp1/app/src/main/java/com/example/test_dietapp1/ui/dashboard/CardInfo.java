package com.example.test_dietapp1.ui.dashboard;

import java.io.Serializable;

public class CardInfo implements Serializable {
    private String[] arrInfo;

    public CardInfo(String[] arrInfo) {
        this.arrInfo = arrInfo;
    }

    public String[] getArrInfo() {
        return arrInfo;
    }

    public void setArrInfo(String[] arrInfo) {
        this.arrInfo = arrInfo;
    }
}
