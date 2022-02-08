package com.example.crudapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "iqcloud.db";
    public static final String TBL_NAME = "Employees";


    public static final String SQL_CREATE_QUERY = "CREATE TABLE " + TBL_NAME + "(id TEXT PRIMARY KEY," +
            "name TEXT, salary TEXT, department TEXT, city TEXT)";
    public static final String SQL_DELETE_QUERY = "DROP TABLE IF EXISTS " + TBL_NAME;

    DBHandler(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionOld, int versionNew) {
        sqLiteDatabase.execSQL(SQL_DELETE_QUERY);
        onCreate(sqLiteDatabase);
    }
}
