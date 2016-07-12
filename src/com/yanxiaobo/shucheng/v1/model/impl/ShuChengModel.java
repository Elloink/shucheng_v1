package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;

import com.yanxiaobo.shucheng.v1.fragment.BookCart;
import com.yanxiaobo.shucheng.v1.fragment.BookMy;
import com.yanxiaobo.shucheng.v1.fragment.BookStore;
import com.yanxiaobo.shucheng.v1.model.IShuChengModel;

public class ShuChengModel implements IShuChengModel{

	@Override
	public List<Fragment> loadFragments() {
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new BookStore());
		fragments.add(new BookCart());
		fragments.add(new BookMy());
		
		return fragments;
	}

}
