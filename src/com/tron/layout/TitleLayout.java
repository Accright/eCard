package com.tron.layout;

import com.Sucre.qrscandemo.R;
import com.activity.PesonalSettingActivity;
import com.activity.ScanActivity;
import com.zxing.activity.CaptureActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {

	private static final int SCANER_CODE = 1;
//	private PopupMenu popupMenu;
	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.title_layout,this);
		Button personButton = (Button)findViewById(R.id.title_back);
		Button qsButton = (Button) findViewById(R.id.title_qs);
//		popupMenu = new PopupMenu((Activity) getContext());
		qsButton.setOnClickListener(new OnClickListener()
				{

					@Override
					public void onClick(View v) {
//						popupMenu.showLocation(R.id.title_qs);// 设置弹出菜单弹出的位置
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.setClass(getContext(), CaptureActivity.class);
						getContext().startActivity(intent);
/*						popupMenu.setOnItemClickListener(new com.tron.layout.PopupMenu.OnItemClickListener()
								{

									@Override
									public void onClick(MENUITEM item, String str) {
										// TODO Auto-generated method stub
										Toast.makeText(getContext(), str, 0).show();
									}
							
								});*/
					}
			
			
				});
		personButton.setOnClickListener(new OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						/*Intent intent = new Intent(getContext(),PesonalSettingActivity.class);
						getContext().startActivity(intent);*/
						((Activity)getContext()).finish();
					}
			
				});
	}

}
