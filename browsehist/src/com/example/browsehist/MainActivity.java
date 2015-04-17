package com.example.browsehist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.Browser;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{
    /** Called when the activity is first created. */
	//int cnt=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBrowserHist();
        
    }

    public void getBrowserHist() {
        try {
            JSONObject parent = new JSONObject();

            String[] proj = new String[] { Browser.BookmarkColumns.TITLE,
                    Browser.BookmarkColumns.URL, Browser.BookmarkColumns.DATE,
                    Browser.BookmarkColumns.VISITS };
            String sel = Browser.BookmarkColumns.BOOKMARK + " = 0";
            Cursor mCur = getContentResolver().query(Browser.BOOKMARKS_URI,
                    proj, sel, null, null);
            mCur.moveToFirst();
            
            if (mCur.moveToFirst() && mCur.getCount() > 0) {
                boolean cont = true;
                while (mCur.isAfterLast() == false && cont) {
                    JSONObject jsonObject = new JSONObject();
                    /*String title = mCur.getString(mCur
                            .getColumnIndex(Browser.BookmarkColumns.TITLE));*/
                    String url = mCur.getString(mCur
                            .getColumnIndex(Browser.BookmarkColumns.URL));
                   /* String date = mCur.getString(mCur
                            .getColumnIndex(Browser.BookmarkColumns.DATE));
                    String visits = mCur.getString(mCur
                            .getColumnIndex(Browser.BookmarkColumns.VISITS));*/
                   /* jsonObject.put("TITLE", title);*/
                    jsonObject.put("", url);
                   /* jsonObject.put("DATE", date);
                    jsonObject.put("VISITS", visits);*/
                    
                    parent.put(url, jsonObject);
                    
                    
                    //parent=null;
                    //cnt++;
                    mCur.moveToNext();
                   
                }
                EditText output = (EditText) findViewById(R.id.outputArea);
               //output.setText(parent.toString(4));
                Toast.makeText(getApplicationContext(), parent.names().toString(),Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), cnt, Toast.LENGTH_LONG).show();
                JSONArray array=parent.names();
                JSONArray values=parent.toJSONArray(array);
                		for(int i=0;i<values.length();i++)
                		{
                			Toast.makeText(getApplicationContext(),array.getString(i), Toast.LENGTH_LONG).show();
                		}
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button copy = (Button) findViewById(R.id.copy);
        copy.setOnClickListener(new OnClickListener() {
            
            
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onClick(View v) {
                EditText output = (EditText) findViewById(R.id.outputArea);
                String data = output.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", data);
                clipboard.setPrimaryClip(clip);
            }
        });

        Button share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new OnClickListener() {
        	
            public void onClick(View v) {
                EditText output = (EditText) findViewById(R.id.outputArea);
                String data = output.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, data);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}