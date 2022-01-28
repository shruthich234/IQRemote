package com.example.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onCreate");
        Log.d(TAG, "onCreate() Loaded the layout..");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() Activity started..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() Activity resumed..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() Activity paused..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onPause");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() Activity restarted..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() Activity stopped..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() Activity destroyed..");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("onDestroy");
    }
}
