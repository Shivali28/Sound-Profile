package com.example.sample;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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


public class MainActivity extends Activity implements OnClickListener{

	Button b1;
	EditText e1;
	TextView t1;
    Socket sock;
    DataInputStream dis;
    DataOutputStream dos;
    public static String str,opr,user,dir;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		t1=(TextView)findViewById(R.id.textView1);
		e1=(EditText)findViewById(R.id.editText1);
		b1.setOnClickListener(this);
		
		try{
		sock = new Socket("192.168.137.24", 1149); 
    	System.out.println("Connecting...");
        dos = new DataOutputStream(sock.getOutputStream());
        dis=new DataInputStream(sock.getInputStream());
        dos.writeUTF(user);
		}
		catch(Exception e)
		{
			Toast.makeText(this,"Sorry! Can not connect with server"+"\n"+"Please try later",Toast.LENGTH_SHORT).show();

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
	/*	Uri uriUrl=Uri.parse("http://www.google.com/");
		Intent launchBrowser=new Intent(Intent.ACTION_VIEW,uriUrl);
		startActivity(launchBrowser);*/
		str=e1.getText().toString();
		
		Intent i = new Intent(this, MainActivity1.class);
		i.putExtra("epuzzle", str);
		startActivity(i); 
		
	}

	

}
