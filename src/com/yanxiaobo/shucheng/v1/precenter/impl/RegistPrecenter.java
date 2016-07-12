package com.yanxiaobo.shucheng.v1.precenter.impl;

import android.graphics.Bitmap;

import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IRegistModel;
import com.yanxiaobo.shucheng.v1.model.impl.RegistModel;
import com.yanxiaobo.shucheng.v1.precenter.IRegistPrecenter;
import com.yanxiaobo.shucheng.v1.view.IRegistView;

public class RegistPrecenter implements IRegistPrecenter{
	
	private IRegistModel model;
	private IRegistView view;
	
	
	
	public RegistPrecenter(IRegistView view) {
		super();
		this.view = view;
		model = new RegistModel();
	}



	@Override
	public void loadImageCode() {
		model.loadImageCode(new CommandCallBack() {
			
			@Override
			public void onDataLoad(Object obj) {
				Bitmap bmp = (Bitmap) obj;
				view.setImageCode(bmp);
			}
		});		
	}



	@Override
	public void regist(String email, String password, String nickname,
			String code) {
		model.regist(email,password,nickname,code,new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				int code = (Integer) obj;
				if(code == 1001){
					view.returnToLogin();
				}
			}
		});
	}

}
