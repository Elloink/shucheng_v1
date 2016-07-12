package com.yanxiaobo.shucheng.v1.model;

import com.yanxiaobo.shucheng.v1.fragment.BookMy;

import android.app.Activity;

public interface IBookMyModel {
	void startLoginPager(Activity activity, BookMy bookMy);
	void loginAuto(CommandCallBack commandCallBack);
	void startAddressPager(Activity activity);
}
