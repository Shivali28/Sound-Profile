package com.example.storetime;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Fixed_Task_Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FixedTask.db";

    public Fixed_Task_Database(Context context, String name,
            CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("CREATE TABLE fixedtask(_id INTEGER PRIMARY KEY AUTOINCREMENT,taskName TEXT, sHour INTEGER, sMinute INTEGER,fHour INTEGER, fMinute INTEGER,taskDay INTEGER,taskMonth INTEGER, taskYear INTEGER )");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS fixedtask");
        onCreate(db);
    }

}