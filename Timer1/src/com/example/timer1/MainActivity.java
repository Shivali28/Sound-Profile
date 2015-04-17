package com.example.timer1;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int initialDelay = 30000; // start after 30 seconds
		int period = 5000;        // repeat every 5 seconds
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		  public void run() {
		    // job code here
			  Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_LONG).show();
		  }
		};
		timer.scheduleAtFixedRate(task, initialDelay, period);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
