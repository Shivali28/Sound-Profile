package com.example.daydemo;

import java.util.Calendar;
import java.util.TimeZone;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		    //currentTime =localCalendar.getTime();
		    //h=currentTime.toString();
		    int currentDayOfWeek =localCalendar.get(Calendar.DAY_OF_WEEK);
		   Toast.makeText(getApplicationContext(), currentDayOfWeek+"", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
