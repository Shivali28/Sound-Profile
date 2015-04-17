package com.example.soundpro;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.IBinder;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	StringBuilder sb;
	DatabaseHelper helper;
	//Date currentTime;
	int daynm,currentDayOfWeek;
	String h,cdate;
	long s;
	  Calendar localCalendar;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override

	  public void onCreate() {

	  super.onCreate();
	  
	  sb=new StringBuilder();
	  helper=new DatabaseHelper(getApplicationContext());
	  
	 //   callAsynchronousTask();
	}

	@Override

	public int onStartCommand(Intent intent, int flags, int startId) {

			Log.d("Service123","Started");	
			Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT);
			//db.rawQuery("select * from Sprofile",null);
			//setprofile();
			callAsynchronousTask();
		
			

	return 0;

	}
	public void setprofile(){
		SQLiteDatabase db=helper.getReadableDatabase();
		//db.rawQuery("DELETE FROM Sprofile",null);
		db.execSQL("DELETE FROM Sprofile");
		Log.d("Database","Deleted");
	}
/*	{
		Timer timer = new Timer();
      TimerTask updateProfile = new CustomerTimerTask(MyService.this);
      timer.scheduleAtFixedRate(updateProfile, 0, s); 
	}
*/
	public void callAsynchronousTask() {
	    final Handler handler = new Handler();
	    final Timer timer = new Timer();
	    TimerTask doAsynchronousTask = new TimerTask() {       
	        @Override
	        public void run() {
	            handler.post(new Runnable() {
	                public void run() {       
	                    try {
	                        //PerformBackgroundTask performBackgroundTask = new PerformBackgroundTask();
	                        // PerformBackgroundTask this class is the class that extends AsynchTask 
	                        //performBackgroundTask.execute();
	                    	//Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG).show();
	                    	SQLiteDatabase db=helper.getReadableDatabase();
	        				db.rawQuery("select * from Sprofile",null);
	        				 cdate=DateFormat.format("yyyy-MM-dd k:m",new Date()).toString();
	        					String []n=cdate.split(" ");
	        					 localCalendar = Calendar.getInstance(TimeZone.getDefault());
	        					   // currentTime =localCalendar.getTime();
	        					  //  h=currentTime.toString();
	        					    currentDayOfWeek =localCalendar.get(Calendar.DAY_OF_WEEK);
	        					   
	        					Cursor cursor=db.rawQuery("select * from Sprofile ", null);
	        					sb=new StringBuilder();
	        					if(cursor.moveToFirst())
	        					{
	        						do
	        						{
	        							String stime,etime,day, pfname; int mili;
	        							stime = cursor.getString(2);
	        							day = cursor.getString(0);
	        							if(day.equalsIgnoreCase("Saturday"))
	        								 day="0";
	        							if(day.equalsIgnoreCase("Sunday"))
	        								day="1";
	        							if(day.equalsIgnoreCase("Monday"))
	        								 day="2";
	        							if(day.equalsIgnoreCase("Tuesday"))
	        								day="3";
	        							if(day.equalsIgnoreCase("Wednesday"))
	        								 day="4";
	        							if(day.equalsIgnoreCase("Thursday"))
	        								day="5";
	        							if(day.equalsIgnoreCase("Friday"))
	        								 day="6";
	        							etime=cursor.getString(3);
	        							pfname = cursor.getString(4);
	        							mili = cursor.getInt(1);		
	        							Log.d("DAY",day+"/"+stime+"/"+etime+"/"+pfname+"/"+mili);
	        							//Toast.makeText(getApplicationContext(), stime,Toast.LENGTH_LONG).show();
	        							//Toast.makeText(getApplicationContext(), n[1],Toast.LENGTH_LONG).show();
	        							daynm=Integer.parseInt(day);
	        							//Toast.makeText(getApplicationContext(), daynm+"",Toast.LENGTH_LONG).show();
	        							String ftime=cursor.getString(2);
	        							//Toast.makeText(getApplicationContext(), ftime,Toast.LENGTH_LONG).show();
	        							
	        							if(daynm==currentDayOfWeek)
	        							{
	        								Log.d("test","tested");
	        								if(stime.equalsIgnoreCase(n[1]))
	        								{
	        									Log.d("inner","Hi");
	        									//Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_LONG).show();
	        									//setprofile();
	        									SetProfile pf = new SetProfile(Integer.parseInt(pfname),getApplicationContext(),mili);
	        									pf.setProfile();
	        									
	        									
	        								}
	        								if(etime.equalsIgnoreCase(n[1]))
	        								{
	        									Log.d("outer","hello");
	        									//SetProfile pf = new SetProfile();
	        									SetProfile pf = new SetProfile(Integer.parseInt(pfname),getApplicationContext(),mili);
	        									pf.setNProfile();
	        									
	        								}
	        								
	        							}
	        							s=Long.parseLong(cursor.getString(1));
	        							//Toast.makeText(getApplicationContext(), s+"", Toast.LENGTH_LONG).show();
	        							sb.append("\n"+cursor.getString(0)+""+cursor.getString(1)+""+cursor.getString(2)+""+cursor.getString(3));
	        							
	        						}while(cursor.moveToNext());
	        						
	        					}
	        					//Toast.makeText(getApplicationContext(), sb,Toast.LENGTH_LONG).show();
	        				
	                    } catch (Exception e) {
	                        // TODO Auto-generated catch block
	                    }
	                }
	            });
	        }
	    };
	    timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 5000 ms
	}
	@Override

	public void onDestroy() {
	super.onDestroy();
	Toast.makeText(getApplicationContext(), "Service End :(", Toast.LENGTH_SHORT);
	Log.d("Service123","END :(");	
	}
}
