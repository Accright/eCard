package com.activity;

import java.util.ArrayList;
import java.util.List;

import com.Sucre.qrscandemo.R;
import com.trin.resideMenu.ResideMenu;
import com.trin.resideMenu.ResideMenuItem;
import com.tron.adapter.CardAdapter;
import com.tron.fragment.CardFragment;
import com.tron.fragment.CouponFragment;
import com.tron.fragment.NearFragment;
import com.tron.javabean.Card;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.audiofx.BassBoost.Settings;
import android.view.View.OnClickListener;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements OnClickListener{

	private CardFragment cardFragment;
	private CouponFragment couponFragment;
	private NearFragment nearFragment;
	
	private View card_layout;
	private View coupon_layout;
	private View near_layout;
	
	private TextView cardText;
	private TextView couponText;
	private TextView nearText;
	
	private ImageView cardImage;
	private ImageView couponImage;
	private ImageView nearImage;
	
	private FragmentManager fragmentManager;
	
	private ResideMenu resideMenu;
	private MainActivity mContext;
	
	private ResideMenuItem itemSettings;
	
	private Button qrScan;
	
//	private ListView listView;//=new ListView(this)
	
//	private List<Card> cardList = new ArrayList<Card>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Log.i("smile", "zhiejieguale");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	//	Bmob.initialize(this, "06eb5674ddca56ad6dc547968d183b70");
		setContentView(R.layout.activity_main);
		Log.i("smile", "初始化界面成功");
	//	Log.i("smile", "运行到MAIN了");
		 mContext = this;
	    setUpMenu();
	    Log.i("smile","setUp Menu is OK!");
		initViews();
		Log.i("smile", "initView is OK!");
//		initCards();
	//	Log.i("smile", "运行到MAIN了");
//		CardAdapter cardAdapter= new CardAdapter(MainActivity.this,R.layout.cardbean,cardList);
//		Log.i("smile",cardAdapter.toString());
//		Log.i("smile", cardText.toString());
		//Log.i("smile", "listview");
//		Log.i("smile", listView.toString());
//		listView.setAdapter(cardAdapter);
//		Log.i("smile", "setadapter");
		fragmentManager=getFragmentManager();
		setTabSelection(1);
//		Log.i("smile", "are you OK???");
	}
	
	
	private void initViews() {
		coupon_layout = findViewById(R.id.coupon_layout);
		card_layout = findViewById(R.id.card_layout);
		near_layout = findViewById(R.id.near_layout);
		Log.i("smile", "initviews somthing wrong");
		cardImage = (ImageView) findViewById(R.id.card_image);
		couponImage = (ImageView) findViewById(R.id.coupon_image);
		nearImage = (ImageView) findViewById(R.id.near_image);
		/*settingImage = (ImageView) findViewById(R.id.setting_image);*/
		cardText = (TextView) findViewById(R.id.card_text);
		couponText = (TextView) findViewById(R.id.coupon_text);
		nearText = (TextView) findViewById(R.id.near_text);
		//settingText = (TextView) findViewById(R.id.setting_text);
//		listView = (ListView) findViewById (R.id.card_listview);
		
		qrScan = (Button) findViewById(R.id.qr_scan);
		
		qrScan.setOnClickListener(this);
		coupon_layout.setOnClickListener(this);
		card_layout.setOnClickListener(this);
		near_layout.setOnClickListener(this);
		/*newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);*/
	} 


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == itemSettings)
		{
			Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
			startActivity(intent);
//			changeFragment(new SettingsFragment());
		}
		resideMenu.closeMenu();
		switch (v.getId()) {
		case R.id.coupon_layout:
			// 当点击了消息tab时，选中第1个tab
			setTabSelection(0);
			Log.i("smile", "Onclick wrong");
			break;
		case R.id.card_layout:
			// 当点击了联系人tab时，选中第2个tab
			setTabSelection(1);
			break;
		case R.id.near_layout:
			// 当点击了动态tab时，选中第3个tab
			setTabSelection(2);
			break;
		case R.id.qr_scan:
			// 当点击了设置tab时，选中第4个tab
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, CaptureActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}	
	
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		Log.i("smile", "setTabSelection right");
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了消息tab时，改变控件的图片和文字颜色
			couponImage.setImageResource(R.drawable.coupon_selected);
			couponText.setTextColor(Color.BLACK);
			if (couponFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				couponFragment = new CouponFragment();
				transaction.add(R.id.content,couponFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(couponFragment);
			}
			Log.i("tab", "tab1");
			break;
		case 1:
			cardImage.setImageResource(R.drawable.card_selected);
			cardText.setTextColor(Color.BLACK);
//			Log.i("smile", "step1");
			if (cardFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				cardFragment = new CardFragment();
//				Log.i("smile", "step2");
				transaction.add(R.id.content,cardFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(cardFragment);
			}
			Log.i("tab", "tab2");
			break;
		case 2:
			nearImage.setImageResource(R.drawable.near_selected);
			nearText.setTextColor(Color.BLACK);
			if (nearFragment == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				nearFragment = new NearFragment();
				transaction.add(R.id.content,nearFragment);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(nearFragment);
			}
			Log.i("tab", "tab3");
			break;
		}
		transaction.commit();
	}
	
	private void clearSelection() {
		cardImage.setImageResource(R.drawable.card_unselected);
		cardText.setTextColor(Color.parseColor("#82858b"));
		couponImage.setImageResource(R.drawable.coupon_unselected);
		couponText.setTextColor(Color.parseColor("#82858b"));
		nearImage.setImageResource(R.drawable.near_unselected);
		nearText.setTextColor(Color.parseColor("#82858b"));
		Log.i("smile", "Picture set success");
		/*settingImage.setImageResource(R.drawable.setting_unselected);
		settingText.setTextColor(Color.parseColor("#82858b"));*/
	}
	
	private void hideFragments(FragmentTransaction transaction) {
		if (couponFragment != null) {
			transaction.hide(couponFragment);
		}
		Log.i("smile", "main is ok");
		if (cardFragment != null) {
			transaction.hide(cardFragment);
		}
		if (nearFragment != null) {
			transaction.hide(nearFragment);
		}
		/*if (settingFragment != null) {
			transaction.hide(settingFragment);
		}*/
	}
	
	
	public void setUpMenu()
	{
//		Log.i("setmenu", "step0 menu");
		resideMenu = new ResideMenu(this);
//		Log.i("setmenu", "step1 menu");
		resideMenu.setBackground(R.drawable.bg);
		resideMenu.attachToActivity(this);
//		Log.i("setmenu", "step2 menu");
        resideMenu.setScaleValue(0.6f);
//        Log.i("setmenu", "step3 menu");
        resideMenu.setShadowVisible(false);
        
        
        itemSettings = new ResideMenuItem(this, R.drawable.card_unselected, "Settings");
        
        itemSettings.setOnClickListener(this);
        
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_LEFT);
		
        findViewById(R.id.testreside).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
	}
	
	/*private void changeFragment(Fragment targetFragment){
       resideMenu.clearIgnoredViewList();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        transaction.add(R.id.content,targetFragment);
        Log.i("smile","已将fragment添加");
        transaction.show(targetFragment);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }*/
	
	public ResideMenu getResideMenu(){
        return resideMenu;
    }
	
/*	private void initCards() {
		Log.i("smile", "init cards");
		Card test1 = new Card("111","test1",R.drawable.testcard1);
		cardList.add(test1);
		Card test2 = new Card("222","test2",R.drawable.testcard2);
		cardList.add(test2);
		Card test3 = new Card("333","test3",R.drawable.testcard3);
		cardList.add(test3);
	}*/
}

