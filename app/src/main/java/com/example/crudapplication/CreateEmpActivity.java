package com.example.crudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateEmpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeId;
    EditText employeeName;
    EditText employeeSalary;
    EditText employeeDepartment;
    EditText employeeLocation;

    DBHandler dbHandler = new DBHandler(this);
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_emp);


        employeeId = findViewById(R.id.empid);

        employeeName = findViewById(R.id.empname);

        employeeSalary = findViewById(R.id.empsalary);

        employeeDepartment = findViewById(R.id.empdept);

        employeeLocation = findViewById(R.id.emplocation);


        Button submitBtn = findViewById(R.id.formsubmit);
        submitBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        String empId = employeeId.getText().toString();
        String empName = employeeName.getText().toString();
        String empSalary = employeeSalary.getText().toString();
        String empDepartment = employeeDepartment.getText().toString();
        String empLocation = employeeLocation.getText().toString();

        Toast.makeText(getBaseContext(), "Welcome" + empId + empName, Toast.LENGTH_LONG).show();

        DBHandler dbHandler = new DBHandler(getBaseContext());
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", empId);
        values.put("name", empName);
        values.put("salary", empSalary);
        values.put("department", empDepartment);
        values.put("city", empLocation);

        long rowId = db.insert(DBHandler.TBL_NAME, null, values);

        Log.i(TAG, "Insert successful..");

       /* //Dialog alert with success msg
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Employee created successfully.Do you want to view details?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getBaseContext(),
                        "Employee Details are :" + empId + " "+ empName + " "+ empSalary + " " + empDepartment + " " + empLocation, Toast.LENGTH_SHORT).show();
            }
        });


        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
*/

        //Progress dialog
        ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setMessage("Loading..");
        progressDialog.show();
        //Dismiss after set timeperiod
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 5000);//5 secs


        //Add AsyncTask implementation



        employeeId.getText().clear();
        employeeDepartment.getText().clear();
        employeeLocation.getText().clear();
        employeeName.getText().clear();
        employeeSalary.getText().clear();

//
//        performUpdate();
//
//        performDelete();


    }


    public void performUpdate() {
        DBHandler dbHandler = new DBHandler(this);


        String id = "123";

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "Swetha");
        values.put("salary", "55000");

        int count = db.update(
                DBHandler.TBL_NAME,
                values,
                "id = ?",
                new String[]{id});


        Log.i(TAG, "Update successful..");
    }


    public void performDelete() {

        DBHandler dbHandler = new DBHandler(this);

        SQLiteDatabase db = dbHandler.getWritableDatabase();

        String id = "123";

        int deletedRows = db.delete(DBHandler.TBL_NAME, "id = ?", new String[]{});

        Log.i(TAG, "Delete succesful..");
    }


}