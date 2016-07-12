package com.yanxiaobo.shucheng.v1.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ShuChengAdapter extends FragmentPagerAdapter{
	private List<Fragment> lists;
	
	public ShuChengAdapter(FragmentManager fm,List<Fragment> lists) {
		super(fm);
		this.lists = lists;
	}

	@Override
	public Fragment getItem(int arg0) {
		return lists.get(arg0);
	}

	@Override
	public int getCount() {
		return lists.size();
	}

}
