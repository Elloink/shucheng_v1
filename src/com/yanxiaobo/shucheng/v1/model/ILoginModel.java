package com.yanxiaobo.shucheng.v1.model;

import android.app.Activity;

public interface ILoginModel {
	void startRegistPager(Activity activity);

	void login(String email, String password, CommandCallBack callback);
	
}
