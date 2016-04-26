package com.activity;

import java.io.UnsupportedEncodingException;

import com.Sucre.qrscandemo.R;
import com.Sucre.qrscandemo.R.id;
import com.Sucre.qrscandemo.R.layout;
import com.Sucre.qrscandemo.R.menu;
import com.google.zxing.WriterException;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

public class CardDetailActivity extends Activity {

	ImageView cardqs ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_card_detail);
		String qsString ;
		Intent qsIntent =  getIntent();
		cardqs= (ImageView) findViewById(R.id.cardqs);
		qsString = qsIntent.getStringExtra("qsStringi");
		try {
			qsString.trim().getBytes("utf-8");
			Log.i("smile", "qsStringi是什么++++"+qsString);
			if (qsString != null && qsString.trim().length()>0) {
				Bitmap bm = EncodingHandler.createQRCode(qsString,800);
				cardqs.setImageBitmap(bm);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.card_detail, menu);
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
