package com.example.soundpro1;

import android.os.Bundle;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity1 extends ListActivity {

    /** We want to display these names as our list items */
   
   DatabaseHelper helper;
   private ArrayAdapter<String> adapter;
   int i;
   String n[];
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        helper=new DatabaseHelper(getApplicationContext());
        i=0;
        SQLiteDatabase db=helper.getReadableDatabase();
		db.rawQuery("select * from Sprofile",null);
		
		
			Cursor cursor=db.rawQuery("select * from Sprofile  ", null);
			
			if(cursor.moveToFirst())
			{
				do
				{
					String stime,etime,day, pfname; int mili;
					stime = cursor.getString(2);
					day = cursor.getString(0);
					etime=cursor.getString(3);
					pfname = cursor.getString(4);
					mili = cursor.getInt(1);
					 n[i]=day+" "+stime+" "+etime+" "+pfname;
					 i++;
					//n={day,stime,etime,pfname};
					Log.d("DAY",day+"/"+stime+"/"+etime+"/"+pfname+"/"+mili);
				    
				}while(cursor.moveToNext());
			}	
			 ArrayList<String> list = new ArrayList<String>(Arrays.asList(n));
		       
		        // Create new ArrayAdapter with the ArrayList as underlying data source
		        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
		       
		        // Assign adapter to the list
		        setListAdapter(adapter);
		       
		        // Assign both click listeners
		       // getListView().setOnItemClickListener(itemListener);
		        //getListView().setOnItemLongClickListener(itemLongListener);
       
}
}