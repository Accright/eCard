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
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity{
	/*---登录Login初始EditText、Button的----------------------------------------*/
	EditText login_username;
	EditText login_password;
	Button login;
	Button register;
	String username,password;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		toast("请登录账号，开始使用");
		Bmob.initialize(this, "06eb5674ddca56ad6dc547968d183b70");
		initView();
		BmobUser user = BmobUser.getCurrentUser(this);
		if(user!=null)
		{
			Intent intent = new Intent(LoginActivity.this,MainActivity.class);
		}
	}
	

	/*--加载控件的函数-------------*/
	private void initView() {
		// TODO Auto-generated method stub
		login_username = (EditText) findViewById(R.id.login_username);
		login_password = (EditText) findViewById(R.id.login_password);
		login = (Button) findViewById(R.id.login);
		register = (Button) findViewById(R.id.register);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username = login_username.getText().toString().trim();
				password = login_password.getText().toString().trim();
				if(username.equals("")){
					
					toast("请填写账号");
					return ;
				}
				if(password.equals("")){
					toast("请填写密码");
				}
				BmobUser user = new BmobUser();
				user.setUsername(username);
				user.setPassword(password);
				user.login(LoginActivity.this, new SaveListener() {
				    @Override
				    public void onSuccess() {
				        // TODO Auto-generated method stub
				        toast("登录成功:");
				        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
						startActivity(intent);
				        
				    }
				    @Override
				    public void onFailure(int code, String msg) {
				        // TODO Auto-generated method stub
				        toast("登录失败:"+msg);
				    }
				});
				
				
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this,RegisteActivity.class);
				startActivity(intent);
				
			}
		});
	}
	
	/*--定义账号密码*/
	

/*	--监听视图动作--
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.login:
			username = login_username.getText().toString().trim();
			password = login_password.getText().toString().trim();
			if(username.equals("")){
				toast("请填写账号");
				return ;
			}
			if(password.equals("")){
				toast("请填写密码");
			}
			BmobUser user = new BmobUser();
			user.setUsername(username);
			user.setPassword(password);
			user.login(this, new SaveListener() {
				
				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					
				}
				
				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					toast("登录失败："+arg1);
					
				}
			});
			break;
		}
		
	}*/
	/*--Toast使用-------------*/
	private void toast(String msg){
		Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
	}

	

	
}
