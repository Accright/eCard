/**
 * 
 */
package com.activity;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Sucre.qrscandemo.R;
import com.google.zxing.WriterException;
import com.zxing.activity.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

/**
 * @author Sucre
 * @category 扫描二维码
 * @desc ScanActivity.java
 * @date 2015年9月8日 下午5:07:56
 */
public class ScanActivity extends Activity {
	Button btnScan, btnRequest, btnGenerate;
	TextView tv;
	ImageView iv;
	EditText namet,aget;
	private static final int SCANER_CODE = 1;
	String s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);
//		Bmob.initialize(this, "06eb5674ddca56ad6dc547968d183b70");
		// 初始化控件
		initViews();
		// 初始化监听
		initlisteners();
	}

	/**
	 * 监听
	 */
	private void initlisteners() {
		btnScan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 打开扫描界面扫描条形码或二维码
				Intent intent = new Intent(ScanActivity.this,
						CaptureActivity.class);
				startActivityForResult(intent, SCANER_CODE);
			}
		});
		btnRequest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 请求网址
				Intent intent = new Intent(ScanActivity.this,
						WebViewActivity.class);
				intent.putExtra("url", s);
				startActivity(intent);
			}
		});
		btnGenerate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 生成二维码
				String s;
				try {
					s = new String(namet.getText().toString().trim()
							.getBytes("utf-8"),"ISO-8859-1");
		//			Log.i("smile", "字符串 ssss"+s);
					if (s != null && s.trim().length()>0) {
						Bitmap bm = EncodingHandler.createQRCode(s,800);
						iv.setImageBitmap(bm);
					} else {
						Toast.makeText(ScanActivity.this,
								"生成二维码的内容不能为空", Toast.LENGTH_SHORT)
								.show();
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (WriterException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 控件
	 */
	private void initViews() {
		btnScan = (Button) findViewById(R.id.scan);
		btnRequest = (Button) findViewById(R.id.request);
		btnGenerate = (Button) findViewById(R.id.generate);
		tv = (TextView) findViewById(R.id.tv);
		iv = (ImageView) findViewById(R.id.iv);
		namet = (EditText) findViewById(R.id.namet);
		aget = (EditText) findViewById(R.id.aget);
	}

	/**
	 * 处理返回结果
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// 处理扫描结果（在界面上显示）
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			if (requestCode == SCANER_CODE) {
				Bundle bundle = data.getExtras();
				s = bundle.getString("result");
				tv.setText(s);
			}
		}
	}
}
