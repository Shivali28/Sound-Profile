package com.example.gui;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity3 extends Activity implements OnTimeChangedListener{
TimePicker t1;
TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		text=(TextView)findViewById(R.id.textView1);
		t1=(TimePicker)findViewById(R.id.timePicker1);
		t1.setOnTimeChangedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
		return true;
	}

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		
		// TODO Auto-generated method stub
		int hour=t1.getCurrentHour();
		int minute1=t1.getCurrentMinute();
		StringBuilder a=new StringBuilder();
		a.append(hour+" "+minute1+"");
		text.setText(a);
		
		
		
		
	}

}
