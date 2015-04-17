package com.example.servedemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

Button play, stop;

play = (Button) findViewById(R.id.button1);

stop = (Button) findViewById(R.id.button2);

play.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent service = new Intent(MainActivity.this, MyService.class);

		startService(service);
	}
});


stop.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent name = new Intent(MainActivity.this, MyService.class);

		stopService(name);
	}
});
}
}
