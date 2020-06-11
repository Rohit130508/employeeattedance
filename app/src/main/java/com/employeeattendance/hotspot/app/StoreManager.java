package com.employeeattendance.hotspot.app;

import android.content.Context;
import android.content.SharedPreferences;

public class StoreManager {
    private SharedPreferences.Editor editor;
    private Context _context;
    public SharedPreferences pref;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "hotspot_store";


    public StoreManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setLoginStatus(Boolean Islogin) {
        editor.putBoolean("LoginValue", Islogin);
        editor.commit();
    }

    public Boolean getLoginStatus() {
        return pref.getBoolean("LoginValue", false);
    }

}

