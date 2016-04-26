package com.activity;

import com.Sucre.qrscandemo.R;
import com.Sucre.qrscandemo.R.id;
import com.Sucre.qrscandemo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class RegisteActivity extends Activity{
	
	EditText register_username;
	EditText register_password;
	EditText register_password1;
	Button login;
	Button register;
	String username,password,password1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_registe);
		Bmob.initialize(this, "06eb5674ddca56ad6dc547968d183b70");
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		register_username =  (EditText) findViewById(R.id.register_username);
		register_password =  (EditText) findViewById(R.id.register_password);
		register_password1 =  (EditText) findViewById(R.id.register_password1);
		login = (Button) findViewById(R.id.login);
		register = (Button) findViewById(R.id.register);

		login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(RegisteActivity.this,LoginActivity.class);
				startActivity(intent);
			}
			
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username = register_username.getText().toString().trim();
				password = register_password.getText().toString().trim();
				password1 = register_password1.getText().toString().trim();
				if(username.equals("")){
					
					toast("请填写账号");
					return ;
				}
				if(password.equals("")){
					toast("请填写密码");
				}
				if(password1.equals("")){
					toast("请填写密码");
					return ;
				}
				
				if(!password1.equals(password)){
					toast("请确认两次密码一致");
					
					return ;
				}
				if(password.length()<6){
					toast("请确保密码长于6");
					return ;
				
					
				}
				BmobUser user = new BmobUser();
				user.setUsername(username);
				user.setPassword(password);
				user.signUp(RegisteActivity.this, new SaveListener() {
					
					
					
					@Override
				    public void onSuccess() {
				        // TODO Auto-generated method stub
				        toast("注册成功:");
				        Intent intent = new Intent(RegisteActivity.this,MainActivity.class);
						startActivity(intent);
				        
				    }
				    @Override
				    public void onFailure(int code, String msg) {
				        // TODO Auto-generated method stub
				        toast("注册失败:"+msg);
				    }
				});
			}
				
		});
		
		
	}
	
	/*--账号密码 密码验证password1*/
	

	/*private class LoginListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.login:
			Intent intent = new Intent(RegisteActivity.this,LoginActivity.class);
			startActivity(intent);
			break;
			
		}}
		
	}*/
	
	
	/*@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.login:
			// TODO Auto-generated method stub
			Intent intent = new Intent(RegisteActivity.this,LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.register:
			username = register_username.getText().toString().trim();
			password = register_password.getText().toString().trim();
			password1 = register_password1.getText().toString().trim();
			if(username.equals("")){
				
				toast("请填写账号");
				return ;
			}
			if(password.equals("")){
				toast("请填写密码");
			}
			if(password1.equals("")){
				toast("请填写密码");
				return ;
			}
			
			if(password1.equals(password)){
				toast("请确认两次密码一致");
				return ;
			}
			BmobUser user = new BmobUser();
			user.setUsername(username);
			user.setPassword(password);
			user.signUp(this, new SaveListener() {
			    @Override
			    public void onSuccess() {
			        // TODO Auto-generated method stub
			        toast("注册成功:");
			    }
			    @Override
			    public void onFailure(int code, String msg) {
			        // TODO Auto-generated method stub
			        toast("注册失败:"+msg);
			    }
			});
			break;
			default:
				System.out.println("default");
				Log.i("", "失败");
			
		}
		
	}*/

	private void toast(String string) {
		// TODO Auto-generated method stub
		Toast.makeText(RegisteActivity.this, string, Toast.LENGTH_SHORT).show();
		
	}

	
}
