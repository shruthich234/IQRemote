package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    protected String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Activity Invoked....");
        testSharedPreferencesWrite();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testSharedPreferencesRead();
            }
        }, 5000);
    }


    protected void testSharedPreferencesWrite() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("ToggleSwitch", false);
        editor.putString("AppName", "LoginApp");
        editor.putInt("Retries", 3);


        editor.commit();


    }


    protected void testSharedPreferencesRead() {
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefs", MODE_PRIVATE);

        Boolean toggle = sharedPreferences.getBoolean("ToggleSwitch", false);
        String appName = sharedPreferences.getString("AppName", "");
        int retries = sharedPreferences.getInt("Retries", 0);

        Log.i(TAG, "Obtained values from dictionary are:");
        Log.i(TAG, "toggle status is" + toggle);
        Log.i(TAG, "App Name is :" + appName);
        Log.i(TAG, "Retries configured are: " + retries);


    }
}