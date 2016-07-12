package com.yanxiaobo.shucheng.v1.precenter.impl;

import android.app.Activity;

import com.yanxiaobo.shucheng.v1.fragment.BookMy;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IBookMyModel;
import com.yanxiaobo.shucheng.v1.model.impl.BookMyModel;
import com.yanxiaobo.shucheng.v1.precenter.IBookMyPrecenter;
import com.yanxiaobo.shucheng.v1.view.IBookMyView;

public class BookMyPrecenter implements IBookMyPrecenter{
	private IBookMyModel model;
	private IBookMyView  view;
	
	
	public BookMyPrecenter(IBookMyView view) {
		super();
		this.view = view;
		model = new BookMyModel();
	}

	@Override
	public void updateUser() {
		view.updateUser();
	}

	@Override
	public void startLoginPager(Activity activity, BookMy bookMy) {
		// TODO Auto-generated method stub
		model.startLoginPager(activity,bookMy);
	}

	@Override
	public void loginAuto() {
		model.loginAuto(new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				view.updateUser();
			}
		});
	}

	@Override
	public void startAddressPager(Activity activity) {
		model.startAddressPager(activity);
	}

}
