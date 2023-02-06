package com.example.test_dietapp1.ui.notifications;

import android.database.sqlite.SQLiteDatabase;
import android.opengl.GLDebugHelper;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.test_dietapp1.R;
import com.example.test_dietapp1.module.NguoiDung;
import com.example.test_dietapp1.sqlite.DatabaseHandler;
import com.example.test_dietapp1.sqlite.NguoiDungDAO;

public class BMRFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        DatabaseHandler db = new DatabaseHandler(getContext());
        SQLiteDatabase database = db.getReadableDatabase();
        database.close();
        //loadSetting(idUser);



        //ListPreference gender = (ListPreference) findPreference("luyentap");
        //gender.setValueIndex(3);
        //CharSequence text = gender.getValue() ;
        //Toast.makeText(getContext(),text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStop(){
        //saveSetting(idUser);
        super.onStop();
    }
    public void loadSetting(String id)
    {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(getContext());
        NguoiDung nguoiDung = nguoiDungDAO.getByMaMA(id);

        ListPreference muctieu = (ListPreference) findPreference("result");
        EditTextPreference kcal = (EditTextPreference) findPreference("kcal/day");
        EditTextPreference height = (EditTextPreference) findPreference("height");
        EditTextPreference weight = (EditTextPreference) findPreference("weight");
        EditTextPreference age = (EditTextPreference) findPreference("age");
        ListPreference gender = (ListPreference) findPreference("gender");
        ListPreference cuongdo = (ListPreference) findPreference("luyentap");
        SwitchPreference check = (SwitchPreference) findPreference("check1");
        height.setText(String.valueOf(nguoiDung.getCHieuCao()));
        weight.setText(String.valueOf(nguoiDung.getCanNang()));
        age.setText(String.valueOf(nguoiDung.getTuoi()));
        gender.setValueIndex(nguoiDung.getGioiTinh());

    }
    public void saveSetting(String id)
    {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(getContext());
        NguoiDung nguoiDung = nguoiDungDAO.getByMaMA(id);

        ListPreference muctieu = (ListPreference) findPreference("result");
        int muctieuVal = Integer.parseInt(muctieu.getValue());
        EditTextPreference kcal = (EditTextPreference) findPreference("kcal/day");
        int kcalVal = Integer.parseInt(kcal.getText());
        EditTextPreference height = (EditTextPreference) findPreference("height");
        int heightVal = Integer.parseInt(height.getText());
        EditTextPreference weight = (EditTextPreference) findPreference("weight");
        float weightVal = Float.parseFloat(weight.getText());
        EditTextPreference age = (EditTextPreference) findPreference("age");
        int ageVal = Integer.parseInt(age.getText());
        ListPreference gender = (ListPreference) findPreference("gender");
        int genderVal = Integer.parseInt(gender.getValue());
        ListPreference cuongdo = (ListPreference) findPreference("luyentap");
        int cuogndoVal = Integer.parseInt(gender.getValue());
        SwitchPreference check = (SwitchPreference) findPreference("check1");
        boolean checkVal = check.isChecked();

        nguoiDung.setCHieuCao(heightVal);
        nguoiDung.setCanNang(weightVal);
        nguoiDung.setTuoi(String.valueOf(ageVal));
        nguoiDung.setGioiTinh(genderVal);
        nguoiDungDAO.updateNguoiDung(nguoiDung);

    }
}