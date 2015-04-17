package com.example.list;


import android.os.Bundle;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;


public class Main1Activity extends ListActivity {

    /** We want to display these names as our list items */
   
   DatabaseHelper helper;
   ListView allData;
   private  ArrayAdapter<String> adapter;
  ArrayList<String> list;
   int i;
   String selectedItem;
   Context context=this;
   String n[];
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        allData=(ListView) findViewById(R.id.listView1);
        list=new ArrayList<String>();
        helper=new DatabaseHelper(getApplicationContext());
        i=0;
        SQLiteDatabase db=helper.getReadableDatabase();
		db.rawQuery("select * from mytab",null);
		
		
			Cursor cursor=db.rawQuery("select * from mytab ", null);
			int na=cursor.getCount();
			//Toast.makeText(getApplicationContext(), na+"", Toast.LENGTH_LONG).show();
			n=new String[na];

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
					 String a=day+" "+stime+" "+etime+" "+pfname;
					list.add(a);
					//n={day,stime,etime,pfname};
					Log.d("DAY",day+"/"+stime+"/"+etime+"/"+pfname+"/"+mili);
				    
				}while(cursor.moveToNext());
			}
			final ArrayAdapter<String> adapter=new ArrayAdapter<String>(Main1Activity.this, android.R.layout.simple_list_item_1,list);
 			allData.setAdapter(adapter);
 		
       
  	    
        
    	
			//String item=parent.
			/*allData.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View v,
						int position, long rowid) {
					// TODO Auto-generated method stub
					//selectedItem=parent.getItemAtPosition(position).toString();
					String del=allData.getSelectedItem().toString();
					Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();

			          
				        
					AlertDialog.Builder builder=new AlertDialog.Builder(context);
					builder.setMessage("Do u want to remove"+selectedItem+"?");
					builder.setCancelable(false);
					builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							adapter.remove(selectedItem);
							adapter.notifyDataSetChanged();
							
							Toast.makeText(getApplicationContext(), selectedItem+"has been removed", Toast.LENGTH_LONG).show();
						}
					});
					builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					builder.show();
					return true;
				}
				
			});
}
    
    public void bindData()
    {
    	 i=0;
         SQLiteDatabase db=helper.getReadableDatabase();
 		db.rawQuery("select * from Sprofile",null);
 		
 		
 			Cursor cursor=db.rawQuery("select * from Sprofile  ", null);
 			int na=cursor.getCount();
 			//Toast.makeText(getApplicationContext(), na+"", Toast.LENGTH_LONG).show();
 			n=new String[na];
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
 			//Toast.makeText(getApplicationContext(), n.toString(), Toast.LENGTH_LONG).show();
 			*/
 			allData.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					String s=list.get(arg2);
					Toast.makeText(Main1Activity.this, "Selected Value"+s, Toast.LENGTH_LONG).show();
					
				}
			});
 			
 		    
    }
}

  
   

	      
	