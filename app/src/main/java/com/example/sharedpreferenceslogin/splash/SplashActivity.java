package com.example.sharedpreferenceslogin.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.example.sharedpreferenceslogin.R;
import com.example.sharedpreferenceslogin.activities.LoginActivity;
import com.example.sharedpreferenceslogin.activities.MainActivity;
import com.example.sharedpreferenceslogin.utils.Utils;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        sPref = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                if (!TextUtils.isEmpty(Utils.getUserMailPrefs(sPref)) &&
                        !TextUtils.isEmpty(Utils.getUserPassPrefs(sPref))){
                    startActivity(intentMain);
                } else {
                    startActivity(intentLogin);
                }
                finish();
            }
        },1000);
    }

}