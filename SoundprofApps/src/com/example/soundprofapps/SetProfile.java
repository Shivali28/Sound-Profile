package com.example.soundprofapps;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import android.widget.Toast;

public class SetProfile {
	
	int st,counter;
	Context c;
	int mili;
	private Context context;
	private AudioManager audioManager;
	public SetProfile(int num,Context co,int mil){
		st = num;
		c = co;
		mili = mil;
		initialize();
	}
	public SetProfile()
	{
		
	}
	public void initialize()
	{
		 audioManager = (AudioManager) c.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
		 counter=0;
	}
	public void setProfile(){
			
			/*Timer timer = new Timer();
		    TimerTask updateProfile = new CustomerTimerTask(c,st,mili);
		      timer.scheduleAtFixedRate(updateProfile, 0, mili); */
		Log.d("pprofile","come in profile set");
		 //audioManager=(AudioManager) context.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
		if(st==0)
		{
			Log.d("setprof","set profile");
			
			audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			counter++;
			//context.getApplicationContext().getSystemService(Context.AUDIO_SERVICE).setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			if(counter==1)
			{
				Toast.makeText(c, "Ringer mode set to silent",Toast.LENGTH_LONG).show();
			}
		}
		if(st==1)
		{
			audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			counter++;if(counter==1)
			{
				Toast.makeText(c, "Ringer mode set to vibrate",Toast.LENGTH_LONG).show();
			}
			
		}
		if(st==2)
		{
			audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			counter++;
			if(counter==1)
			{
				Toast.makeText(c, "Ringer mode set to silent",Toast.LENGTH_LONG).show();
			}
		}
		
		
		     
	}
	public void setNProfile()
	{
		Log.d("cprof","change profile");
		//AudioManager audioManager = (AudioManager) c.getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
		//audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		//AudioManager audioManager = c.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		counter++;
		if(counter==1)
		{
			Toast.makeText(c, "Ringer mode set to normal",Toast.LENGTH_LONG).show();
		}
	}
}

