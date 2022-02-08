package com.example.crudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListEmpActivity extends AppCompatActivity {


    public final String TAG = ListEmpActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_emp);

        ListView listView = findViewById(R.id.simpleListView);
        Employee[] employees = {new Employee("120","shruti","34000","HR", "Hyderabad"),
                new Employee("220","driti","34000","HR", "Bangalore")};
//        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.activity_list_emp, R.id.itemTextView, employees);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), employees);
        listView.setAdapter(customAdapter);

    }

    public void performReadOperation() {
        DBHandler dbHandler = new DBHandler(this);
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String sal = "1000";
        Cursor cursor = db.query(DBHandler.TBL_NAME, new String[]{"id", "name", "salary", "department", "city"},
                "salary > ?", new String[]{sal}, null, null, "name DESC");

        List<Employee> employees = new ArrayList<>();
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String salary = cursor.getString(cursor.getColumnIndexOrThrow("salary"));
            String department = cursor.getString(cursor.getColumnIndexOrThrow("department"));
            String city = cursor.getString(cursor.getColumnIndexOrThrow("city"));


            employees.add(new Employee(id, name, salary, department, city));

        }

        Log.i(TAG, "Read succesful..");
        for (Employee emp : employees)
            Log.i(TAG, emp.toString());

        cursor.close();
    }


}