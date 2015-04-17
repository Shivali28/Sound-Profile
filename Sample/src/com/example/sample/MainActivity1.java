package com.example.sample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity1 extends Activity {
	EditText ed1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		ed1=(EditText)findViewById(R.id.editText1);
		Intent intent = getIntent();
		String easyPuzzle = intent.getExtras().getString("epuzzle");
		ed1.setText(easyPuzzle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
		
	}

}
