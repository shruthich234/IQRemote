package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() Loaded the layout..");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() Activity paused..");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() Activity resumed..");
    }




}