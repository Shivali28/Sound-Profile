package com.example.datechck;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity implements OnTimeChangedListener{

	TimePicker t1;
	int hr,min;
	String sr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TimePicker t1=(TimePicker)findViewById(R.id.timePicker1);
		t1.setOnTimeChangedListener(this);
		sr=hr+""+min+"";
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
		hr=t1.getCurrentHour();
		min=t1.getCurrentMinute();
	}

}
