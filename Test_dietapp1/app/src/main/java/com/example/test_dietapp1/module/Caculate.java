package com.example.test_dietapp1.module;

import android.database.sqlite.SQLiteDatabase;

public class Caculate {
    public float BMR;
    public float R;
    public float TDEE;

    public Caculate(float bmr, float r, float tdee)
    {
        super();
        this.BMR = bmr;
        this.R = r;
        this.TDEE = tdee;
    }

    public float getBMR() {
        return BMR;
    }

    public void setBMR(float BMR) {
        this.BMR = BMR;
    }

    public float getR() {
        return R;
    }

    public void setR(float r) {
        R = r;
    }

    public float getTDEE() {
        return TDEE;
    }

    public void setTDEE(float TDEE) {
        this.TDEE = TDEE;
    }


}
