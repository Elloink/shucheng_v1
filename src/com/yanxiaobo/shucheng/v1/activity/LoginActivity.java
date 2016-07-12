package com.yanxiaobo.shucheng.v1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.consts.Consts;
import com.yanxiaobo.shucheng.v1.precenter.ILoginPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.LoginPrecenter;
import com.yanxiaobo.shucheng.v1.view.ILoginView;

public class LoginActivity extends Activity implements ILoginView ,OnClickListener{
	private ILoginPrecenter precenter;
	
	private TextView tvNewUser;
	private EditText etUserName;
	private EditText etPassword;
	private Button btLogin;

	private String email;
	private String password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		precenter = new LoginPrecenter(this);
		setViews();
		setListeners();
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void setViews() {
		tvNewUser = (TextView) findViewById(R.id.tv_new_user);
		etUserName = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_userpassword);
		btLogin = (Button) findViewById(R.id.bt_login);
	}
	/**
	 * �ռ�ע�����ش��Ĳ���
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==Consts.START_REGISTPAGER_RESPONSE){
			if(resultCode==Activity.RESULT_OK){
				etUserName.setText(data.getStringExtra("email"));
				etPassword.setText(data.getStringExtra("password"));
			}
		}
	}
	/**
	 * ���ü���
	 */
	private void setListeners(){
		tvNewUser.setOnClickListener(this);
		btLogin.setOnClickListener(this);
	}

	/**
	 * ����������Ӧ
	 * @param v
	 */
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.tv_new_user:
			precenter.startRegistPager(this);
			break;
		case R.id.bt_login:
			email = etUserName.getText().toString();
			password = etPassword.getText().toString();
			precenter.login(email,password);
			break;
		}
		
	}
	
	/**
	 * ��¼�ɹ����ص�  ���ҵ�T-Book" ����
	 */
	@Override
	public void returnToMyTBook() {
		System.out.println(DangApplication.getUser().getNickname());
		setResult(Activity.RESULT_OK);
		finish();
	}

	
	
}
