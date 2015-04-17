package com.example.soundpro;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "dbname", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("CREATE TABLE Sprofile(dayname text,b int,c text,end text,pfname text);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		//arg0.execSQL("CREATE TABLE Sprofile(id INTEGER PRIMARY KEY AUTOINCREMENT,dayname text,b int,c text,end text,pfname text);");
	}

}

