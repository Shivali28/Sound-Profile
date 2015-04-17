package com.example.soundproapp;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTimeChangedListener {
	Spinner sp1,sp2;
	TimePicker t1,t2;
	Button b1,b2;
	int hr1,hr2,min1,min2,hr,min,hr3,min3;
	StringBuilder s1,s2;
	String g,h;
	String stime =null,etime=null;
	DatabaseHelper helper;
	Calendar localCalendar;
	int currentDayOfWeek;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addItemsOnSpinner1();
		addItemsOnSpinner2();
		addListenerOnSpinnerItemSelection();
		t1=(TimePicker)findViewById(R.id.timePicker1);
		t2=(TimePicker)findViewById(R.id.timePicker2);
		t1.setOnTimeChangedListener(this);
		t2.setOnTimeChangedListener(this);
		s1=new StringBuilder();
		helper=new DatabaseHelper(getApplicationContext());
		//b1=(Button)findViewById(R.id.button1);
		/*b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=helper.getWritableDatabase();
				ContentValues values=new ContentValues();
				String a=sp1.getSelectedItem().toString();
				if(a.equalsIgnoreCase("Saturday"))
					 g="0";
				if(a.equalsIgnoreCase("Sunday"))
					g="1";
				if(a.equalsIgnoreCase("Monday"))
					 g="2";
				if(a.equalsIgnoreCase("Tuesday"))
					g="3";
				if(a.equalsIgnoreCase("Wednesday"))
					 g="4";
				if(a.equalsIgnoreCase("Thursday"))
					g="5";
				if(a.equalsIgnoreCase("Friday"))
					 g="6";
				String e=s1.toString();
				String f=sp2.getSelectedItem().toString();
				if(f.equalsIgnoreCase("Silent"))
					h="0";
				if(f.equalsIgnoreCase("Vibrate"))
					h="1";
				if(f.equalsIgnoreCase("Normal"))
					h="2";
				values.put("dayname", a);
				hr=(hr2-hr1)*3600;
		        min=(min2-min1)*60;
				 int tot=(hr+min)*1000;
				values.put("b",tot);
				values.put("c", stime);
				values.put("end", etime);
				values.put("pfname", h);
				int i=(int)db.insert("Sprofile", null, values);
				if(i==0)
					Toast.makeText(getApplicationContext(), "Unsuccessfully inserted",Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getApplicationContext(), "Successfully inserted",Toast.LENGTH_LONG).show();
			db.close();
			
			 
			Intent service = new Intent(MainActivity.this, MyService.class);
			startService(service);
				
							}

					});*/
		//b2=(Button)findViewById(R.id.button2);
		/*b2.setOnClickListener(new OnClickListener() {
			

			public void onClick(View arg0) {
				Intent i=new Intent(getApplicationContext(),MainActivity1.class);
				startActivity(i);
				
				
					/*SQLiteDatabase db=helper.getReadableDatabase();
					//db.rawQuery("DELETE FROM Sprofile",null);
					db.execSQL("DELETE FROM Sprofile");
					Toast.makeText(getApplicationContext(), "Record deleted",Toast.LENGTH_LONG).show();
					Log.d("Database","Deleted");
				
				
				
			}
		});*/
		
	}
	
	public void addItemsOnSpinner1() {
		  
		sp1 = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("Enter Day");
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		list.add("Thursday");
		list.add("Friday");
		list.add("Saturday");
		list.add("Sunday");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		

		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp1.setAdapter(dataAdapter);
	  }
	public void addItemsOnSpinner2() {
		  
		sp2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list = new ArrayList<String>();
		list.add("Select profile");
		list.add("Silent");
		list.add("Vibrate");
		list.add("Normal");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp2.setAdapter(dataAdapter);
	  }
	public void addListenerOnSpinnerItemSelection() {
		sp1 = (Spinner) findViewById(R.id.spinner1);
		sp1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		sp2 = (Spinner) findViewById(R.id.spinner2);
		sp2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.timePicker1)
		{
			hr1=0;
			min1=0;
			hr1=t1.getCurrentHour();
			min1=t1.getCurrentMinute();
			s1.append(hr1+":"+min1);
			stime = String.valueOf(hr1)+":"+String.valueOf(min1);
			//Toast.makeText(getApplicationContext(), "Start Time Set",Toast.LENGTH_LONG).show();
			Log.d("TIME START",stime);
			Log.d("HRMIN1",String.valueOf(hr1)+"/"+String.valueOf(min1));
			
		}
		else
		{
			hr2=0;
			min2=0;
			hr2=t2.getCurrentHour();
			min2=t2.getCurrentMinute();
			etime = String.valueOf(hr2)+":"+String.valueOf(min2);
			Log.d("HRMIN2",String.valueOf(hr2)+"/"+String.valueOf(min2));
		}
	}
	

}


