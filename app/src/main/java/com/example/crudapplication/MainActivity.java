package com.example.crudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void showEmployees(View view) {
        Intent intent = new Intent(MainActivity.this, ListEmpActivity.class);
        startActivity(intent);
    }


    public void createEmployees(View view) {
        Intent intent = new Intent(MainActivity.this, CreateEmpActivity.class);
        startActivity(intent);
    }

    public void updateEmployees(View view) {
//        Intent intent = new Intent(MainActivity.this, ListEmpActivity.class);
//        startActivity(intent);
    }

    public void deleteEmployees(View view) {
//        Intent intent = new Intent(MainActivity.this, ListEmpActivity.class);
//        startActivity(intent);
    }


}