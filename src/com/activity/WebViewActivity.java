/**
 * 
 */
package com.activity;

import com.Sucre.qrscandemo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * @author Sucre
 * @category WebView展示
 * @desc WebViewActivity.java
 * @date 2015年9月8日 下午4:42:28
 */
public class WebViewActivity extends Activity {
	WebView wv;
	WebSettings webSettings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		Intent intent = getIntent();
		String s = intent.getStringExtra("url");
		
		wv = (WebView) findViewById(R.id.webview);
		webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webSettings.setLoadsImagesAutomatically(true);
		wv.loadUrl(s);
	}
}
