package com.yanxiaobo.shucheng.v1.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.precenter.IRegistPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.RegistPrecenter;
import com.yanxiaobo.shucheng.v1.view.IRegistView;

public class RegistActivity extends Activity implements IRegistView,OnClickListener{
	private IRegistPrecenter precenter;
	
	private ImageView ivCode;
	private Button btRegist;
	
	private EditText etEmail;
	private EditText etPassword;
	private EditText etNickname;
	private EditText etCode;

	private String email;

	private String password;

	private String nickname;

	private String code;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		
		setViews();
		precenter = new RegistPrecenter(this);
		precenter.loadImageCode();
		setListeners();
	}
	/**
	 * 初始化控件
	 */
	private void setViews() {
		ivCode = (ImageView) findViewById(R.id.iv_code);		
		btRegist = (Button) findViewById(R.id.bt_regist);
		
		etEmail = (EditText) findViewById(R.id.et_user_email);
		etPassword = (EditText) findViewById(R.id.et_user_password);
		etNickname = (EditText) findViewById(R.id.et_regist_user_nickname);
		etCode = (EditText) findViewById(R.id.et_regist_user_code);
	}
	/**
	 * 设置监听
	 */
	private void setListeners(){
		ivCode.setOnClickListener(this);
		btRegist.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regist, menu);
		return true;
	}

	@Override
	public void setImageCode(Bitmap bmp) {
		ivCode.setImageBitmap(bmp);		
	}
	
	
	/**
	 * 监听响应方法
	 * @param v
	 */
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.iv_code:
			precenter.loadImageCode();
			break;
		case R.id.bt_regist:
			email = etEmail.getText().toString().trim();
			password = etPassword.getText().toString().trim();
			nickname = etNickname.getText().toString().trim();
			code = etCode.getText().toString().trim();
			
			precenter.regist(email, password, nickname, code);
			break;
		}
		
	}
	
	/**
	 * 注册成功，转到登录界面
	 */
	@Override
	public void returnToLogin() {
		Intent intent = new Intent(this, LoginActivity.class);
		intent.putExtra("email", email);
		intent.putExtra("password", password);
		setResult(Activity.RESULT_OK, intent);
		finish();
	}
}
