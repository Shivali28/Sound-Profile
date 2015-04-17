package com.example.soundpro;

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


public class MainActivity1 extends Activity {

    /** We want to display these names as our list items */
   
   DatabaseHelper helper;
   SQLiteDatabase db; //= helper.getWritableDatabase();
   ListView allData;
   private  ArrayAdapter<String> adapter;
  ArrayList<String> list;
   int i;
   String selectedItem;
   Context context=this;
   String n[],m[];
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all);
        allData=(ListView) findViewById(R.id.listView1);
        helper=new DatabaseHelper(getApplicationContext());
        i=0;
        list = new ArrayList<String>();
       bindData();
     /*   SQLiteDatabase db=helper.getReadableDatabase();
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
 					 String a=day+" "+stime+" "+etime+" "+pfname;
 					 list.add(a);
 					 
 					//n={day,stime,etime,pfname};
 					Log.d("DDAY",day+"/"+stime+"/"+etime+"/"+pfname);
 				    
 				}while(cursor.moveToNext());
 			}

        adapter = new ArrayAdapter<String>(MainActivity1.this,
                android.R.layout.simple_list_item_1, list);
        allData.setAdapter(adapter);
*/
        // For ListItem Click
     allData.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String s = list.get(arg2);
            Toast.makeText(MainActivity1.this, "Selected Month is " + s,
                    3000).show();
           String m[]=s.split(" ");
           //Toast.makeText(getApplicationContext(), m[0],Toast.LENGTH_LONG).show();
           //Toast.makeText(getApplicationContext(), m[2],Toast.LENGTH_LONG).show();
          
           //SQLiteDatabase db=helper.getWritableDatabase();
   		//db.rawQuery("DELETE FROM Sprofile",null);
         //  db.delete("Sprofile", "daynm='4'", null);
           
           String a=m[0];
           String b=m[2];
   		//db.execSQL("DELETE FROM Sprofile where dayname=a");
   		Toast.makeText(getApplicationContext(), "Database Deleted", Toast.LENGTH_LONG).show();
   		adapter.remove(s);
			//bindData();
		}
	})
      ;
        
			/*final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,n);
 			allData.setAdapter(adapter);*/
 		
       
  	    
        
    }		
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
				
			});*/
    
    public void bindData()
    {
    	 i=0;
         db=helper.getWritableDatabase();
 		db.rawQuery("select * from Sprofile",null);
 		
 		
 			Cursor cursor=db.rawQuery("select * from Sprofile  ", null);
 			int na=cursor.getCount();
 			//Toast.makeText(getApplicationContext(), na+"", Toast.LENGTH_LONG).show();
 			n=new String[na];
 			//list.remove(allData);
 			if(cursor.moveToFirst())
 			{
 				do
 				{
 					String stime,etime,day, pfname; int mili;
 					stime = cursor.getString(2);
 					day = cursor.getString(0);
 					etime=cursor.getString(3);
 					//pfname = cursor.getString(4);
 					mili = cursor.getInt(1);
 					 String a=day+" "+stime+" "+etime+"";
 					 list.add(a);
 					//n={day,stime,etime,pfname};
 					Log.d("DAY",day+"/"+stime+"/"+etime+"/"+mili);
 				    
 				}while(cursor.moveToNext());
 			//	db.close();
 			}
 			//Toast.makeText(getApplicationContext(), n.toString(), Toast.LENGTH_LONG).show();
 		      adapter = new ArrayAdapter<String>(MainActivity1.this,
 		                android.R.layout.simple_list_item_1, list);
 		        allData.setAdapter(adapter);
 			
 		    
    }
}

  
   

	      
	