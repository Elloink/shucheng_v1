package com.yanxiaobo.shucheng.v1.precenter.impl;

import java.util.List;

import android.support.v4.app.Fragment;

import com.yanxiaobo.shucheng.v1.model.IShuChengModel;
import com.yanxiaobo.shucheng.v1.model.impl.ShuChengModel;
import com.yanxiaobo.shucheng.v1.precenter.IShuChengPrecenter;
import com.yanxiaobo.shucheng.v1.view.IShuChengView;

public class ShuChengPrecenter implements IShuChengPrecenter{
	private IShuChengModel scModel;
	private IShuChengView view;
	
	public ShuChengPrecenter(IShuChengView view){
		this.view = view;
		scModel = new ShuChengModel();
	}
	@Override
	public void loadAllPagers() {
		List<Fragment> lists = scModel.loadFragments();
		view.setAllPageData(lists);
		view.displayPagers();		
	}

}
