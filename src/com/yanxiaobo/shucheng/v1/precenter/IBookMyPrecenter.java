package com.yanxiaobo.shucheng.v1.precenter;

import com.yanxiaobo.shucheng.v1.fragment.BookMy;

import android.app.Activity;

public interface IBookMyPrecenter {
	void startLoginPager(Activity activity, BookMy bookMy);
	void updateUser();
	void loginAuto();
	void startAddressPager(Activity activity);
}
