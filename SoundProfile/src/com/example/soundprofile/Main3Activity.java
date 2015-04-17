package com.example.soundprofile;





import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class Main3Activity extends Activity implements OnTimeChangedListener {
	DataBaseHelper helper;
	TimePicker t1,t2;
	TextView profile1;
	Button add1,cancel1,monday1;
	int hour,minute;
	StringBuilder str,str1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		add1=(Button)findViewById(R.id.add);
		cancel1=(Button)findViewById(R.id.cancel);
		monday1=(Button)findViewById(R.id.monday);
		t1=(TimePicker)findViewById(R.id.timePicker1);
		t2=(TimePicker)findViewById(R.id.timePicker2);
		helper=new DataBaseHelper(getApplicationContext());
		profile1=(TextView)findViewById(R.id.profile);
		profile1.setText("Silent");
		str=new StringBuilder();
		str1=new StringBuilder();
		t1.setOnTimeChangedListener(this);
		t2.setOnTimeChangedListener(this);
		add1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db=helper.getWritableDatabase();
				ContentValues values=new ContentValues();
				String a=monday1.getText().toString();
				String b=str.toString();
				String e=str1.toString();
				String f=profile1.getText().toString();
				values.put("day", a);
				values.put("from", b);
				values.put("to", e);
				values.put("pfname", f);
				int i=(int)db.insert("Sprofile", null, values);
				if(i==0)
					Toast.makeText(getApplicationContext(), "Unsuccessfully inserted",Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getApplicationContext(), "Successfully inserted",Toast.LENGTH_LONG).show();
			db.close();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main3, menu);
		return true;
	}

	@Override
	public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.timePicker1)
		{
		int hour=t1.getCurrentHour();
		int minute=t1.getCurrentMinute();
		str.append(hour+""+minute+"");
		}
		else
		{
			int hour=t1.getCurrentHour();
			int minute=t1.getCurrentMinute();
			str1.append(hour+""+minute+"");
		}
			
	}

}
