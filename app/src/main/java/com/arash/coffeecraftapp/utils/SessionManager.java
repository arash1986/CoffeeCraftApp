package com.arash.coffeecraftapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.arash.coffeecraftapp.R;

public class SessionManager {
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(context.getString(R.string.app_name), PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setLightMode(Boolean lightMode) {
        editor.putBoolean("lightMode",lightMode);
        editor.commit();
    }

    public Boolean getLightMode() {
        return pref.getBoolean("lightMode", true);
    }

}
