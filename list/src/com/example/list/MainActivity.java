package com.example.list;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button b1,b2;
	EditText t1,t2;
	DatabaseHelper helper;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.add);
		b2=(Button)findViewById(R.id.delete);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.add)
		{
			SQLiteDatabase db=helper.getWritableDatabase();
			ContentValues values=new ContentValues();
			String id1=t1.getText().toString();
			String name1=t2.getText().toString();
			
			values.put("id", id1);
			values.put("name", name1);
			int i=(int)db.insert("mytab", null, values);
			if(i==0)
			{
				Toast.makeText(getApplicationContext(), "UnSuccessfully Inserted", Toast.LENGTH_LONG).show();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_LONG).show();
			}
		
	}

	}
}
