package com.example.sharedpreferenceslogin.utils;

import android.content.SharedPreferences;

public class Utils {

    public static String getUserMailPrefs(SharedPreferences preferences){
        return preferences.getString("email", "");
    }

    public static String getUserPassPrefs(SharedPreferences preferences){
        return preferences.getString("pass", "");
    }
}
