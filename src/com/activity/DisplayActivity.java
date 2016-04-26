package com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import com.Sucre.qrscandemo.R;
import com.Sucre.qrscandemo.R.id;
import com.Sucre.qrscandemo.R.layout;
import com.Sucre.qrscandemo.R.menu;

public class DisplayActivity extends Activity {

	TextView userName;//=(TextView) findViewById(R.id.user_name);
	TextView userId;//=(TextView) findViewById(R.id.user_id);
	//String qsresult[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.display_layout);
		userName=(TextView) findViewById(R.id.user_name);
		userId=(TextView) findViewById(R.id.user_id);
		Intent resultIntent=getIntent();
		Log.i("smile", "the intent is"+resultIntent.toString());
		Bundle temp=resultIntent.getExtras();
		Log.i("smile", "the bundle is"+temp.toString());
		String qsresult[]=temp.getString("result").split(":");
		userName.setText(qsresult[0]);
		userId.setText(qsresult[1]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
