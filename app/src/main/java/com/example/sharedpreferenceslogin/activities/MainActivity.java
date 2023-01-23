package com.example.sharedpreferenceslogin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sharedpreferenceslogin.R;
import com.example.sharedpreferenceslogin.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sPref;
    private TextView textViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUser = findViewById(R.id.textViewUser);
        sPref = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        String email = Utils.getUserMailPrefs(sPref);
        textViewUser.setText("Welcome, " + email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                logOut();
                return true;
            case R.id.menu_forget_logout:
                removeSharedPreferences();
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logOut(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void removeSharedPreferences(){
        sPref.edit().clear().apply();
    }
}