package com.activity;

import com.Sucre.qrscandemo.R;
import com.Sucre.qrscandemo.R.id;
import com.Sucre.qrscandemo.R.layout;
import com.Sucre.qrscandemo.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class PesonalSettingActivity extends Activity{

	private EditText qrCardName;
	private EditText qrCardId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_qr_build);
	/*	EditText qrCardName = (EditText) findViewById(R.id.qr_card_name);
		EditText qrCardId = (EditText) findViewById(R.id.qr_card_id);
		Button qsBuild = (Button) findViewById(R.id.qrbuild);
		String qrName = qrCardName.getText().toString();
		String qrId = qrCardId.getText().toString();
		qsBuild.setOnClickListener(this);*/
		qrCardName = (EditText) findViewById(R.id.qr_card_name);
		qrCardId = (EditText) findViewById(R.id.qr_card_id);
		Button qsBuild = (Button) findViewById(R.id.qrbuild);
		qsBuild.setOnClickListener(new OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String qrName = qrCardName.getText().toString();
						String qrId = qrCardId.getText().toString();
						Intent qrIntent = new Intent(PesonalSettingActivity.this,CardDetailActivity.class);
						qrIntent.putExtra("qsStringi",qrName+":"+qrId);
						startActivity(qrIntent);
					}
			
				});
	//	initViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pesonal_setting, menu);
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
	/*public void initViews()
	{
		EditText qrCardName = (EditText) findViewById(R.id.qr_card_name);
		EditText qrCardId = (EditText) findViewById(R.id.qr_card_id);
		Button qsBuild = (Button) findViewById(R.id.qrbuild);
		qsBuild.setOnClickListener(this);
	}
	@Override*/
	/*public void onClick(View v) {
		// TODO Auto-generated method stub
		String qrName = qrCardName.getText().toString();
		String qrId = qrCardId.getText().toString();
		Intent qrIntent = new Intent(PesonalSettingActivity.this,CardDetailActivity.class);
		qrIntent.putExtra("qrstringi",qrName+":"+qrId);
		startActivity(qrIntent);
	}*/

}
