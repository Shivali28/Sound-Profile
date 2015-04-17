package com.example.pmse;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends Activity implements OnClickListener{

	Button b1;
	EditText e1;
	TextView t1;
    Socket sock;
    DataInputStream dis;
    DataOutputStream dos;
    public static String str,opr,user,dir;
    String s;
    DatabaseHelper helper;
    Intent launchBrowser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		t1=(TextView)findViewById(R.id.textView1);
		e1=(EditText)findViewById(R.id.editText1);
		helper=new DatabaseHelper(getApplicationContext());
		b1.setOnClickListener(this);
		getBrowserHist();
		
		try{
		sock = new Socket("192.168.137.167", 5051); 
    	System.out.println("Connecting...");
        dos = new DataOutputStream(sock.getOutputStream());
        dis=new DataInputStream(sock.getInputStream());
        dos.writeUTF(e1.getText().toString());
		}
		catch(Exception e)
		{
			Toast.makeText(this,"Sorry! Can not connect with server"+"\n"+"Please try later",Toast.LENGTH_SHORT).show();

		}
		
		
	}

    public void getBrowserHist() {
        try {
        	SQLiteDatabase db=helper.getWritableDatabase();
			ContentValues value=new ContentValues();
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
                //EditText output = (EditText) findViewById(R.id.outputArea);
               //output.setText(parent.toString(4));
                Toast.makeText(getApplicationContext(), parent.names().toString(),Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), cnt, Toast.LENGTH_LONG).show();
                JSONArray array=parent.names();
                JSONArray values=parent.toJSONArray(array);
                		for(int i=0;i<values.length();i++)
                		{
                			Toast.makeText(getApplicationContext(),array.getString(i), Toast.LENGTH_LONG).show();
                			value.put("keyword",e1.getText().toString());
                			value.put("url",array.getString(i));
                			
                		}
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public boolean isindb(String s)
    {
    	SQLiteDatabase db=helper.getReadableDatabase();
		db.rawQuery("select * from history",null);
		Cursor cursor=db.rawQuery("select * from history where name=s  ", null);
		if(cursor.getCount()==0)
		{
			return false;
		}
		else
		{
			return true;
		}
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
		String s=e1.getText().toString();
		if(!isindb(s))
		{
		String n="https://in.search.yahoo.com/search?p="+e1.getText().toString()+"&fr=yfp-t-704";
		Uri uriUrl=Uri.parse(n);
		 launchBrowser=new Intent(Intent.ACTION_VIEW,uriUrl);
		startActivity(launchBrowser);
		getBrowserHist();
		}
		else
		{
			
		}
		
	}

	

}
