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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListEmpActivity extends AppCompatActivity {


    public final String TAG = ListEmpActivity.class.getSimpleName();
    public int listSize = 3;
    public final String employeesStr = ("{ \"employees\" :[" +
            "{\"id\":\"76\",\"name\":\"Ace\",\"salary\":\"12000\",\"location\":\"New York\", \"department\":\"HR\"}" +
            ",{\"id\":\"9876\",\"name\":\"Tom\",\"salary\":\"25000\",\"location\":\"Chicago\", \"department\":\"Development\"}" +
            ",{\"id\":\"9865\",\"name\":\"Tim\",\"salary\":\"5000\",\"location\":\"Sunnyvale\", \"department\":\"Finance\"}] }");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_emp);

        ListView listView = findViewById(R.id.simpleListView);
        Employee[] employees = new Employee[listSize];
//        employees = {new Employee("120","shruti","34000","HR", "Hyderabad"),
//                new Employee("220","driti","34000","HR", "Bangalore"),
//                new Employee("320","swrishti","34000","HR", "Hyd")};

//        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, R.layout.activity_list_emp, R.id.itemTextView, employees);

        try {
            JSONObject emps = new JSONObject(employeesStr);
            JSONArray empArr = emps.getJSONArray("employees");
            for (int i = 0; i < empArr.length(); i++) {
                JSONObject json = empArr.getJSONObject(i);
                String id = json.getString("id");
                String name = json.getString("name");
                String salary = json.getString("salary");
                String department = json.getString("department");
                String location = json.getString("location");


                employees[i] = new Employee(id, name, salary, department, location);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter customAdapter = new CustomAdapter(ListEmpActivity.this, employees);
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