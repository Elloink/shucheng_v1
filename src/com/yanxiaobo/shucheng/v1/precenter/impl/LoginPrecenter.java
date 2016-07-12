package com.yanxiaobo.shucheng.v1.precenter.impl;

import android.app.Activity;

import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.ILoginModel;
import com.yanxiaobo.shucheng.v1.model.impl.LoginModel;
import com.yanxiaobo.shucheng.v1.precenter.ILoginPrecenter;
import com.yanxiaobo.shucheng.v1.view.ILoginView;

public class LoginPrecenter implements ILoginPrecenter{
	private ILoginView view;
	private ILoginModel model;
	
	
	public LoginPrecenter(ILoginView view) {
		super();
		this.view = view;
		model = new LoginModel();
	}


	@Override
	public void startRegistPager(Activity activity) {
		model.startRegistPager(activity);
	}


	@Override
	public void login(String email, String password) {
		model.login(email,password,new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				view.returnToMyTBook();
			}
		});		
	}

}
