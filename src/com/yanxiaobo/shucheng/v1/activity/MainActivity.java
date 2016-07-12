package com.yanxiaobo.shucheng.v1.activity;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.adapter.ShuChengAdapter;
import com.yanxiaobo.shucheng.v1.entity.Cart;
import com.yanxiaobo.shucheng.v1.precenter.IShuChengPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.ShuChengPrecenter;
import com.yanxiaobo.shucheng.v1.view.IShuChengView;

public class MainActivity extends FragmentActivity implements IShuChengView {
	private RadioGroup rgNavigate;
	
	private ViewPager vpShuCheng;
	private List<Fragment> fragments;
	private ShuChengAdapter adapter;
	
	private IShuChengPrecenter scPrecenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setViews();
		scPrecenter = new ShuChengPrecenter(this);
		scPrecenter.loadAllPagers();
		setListeners();
	}

	/**
	 * 设置监听
	 * 实现ViwPager和RadioGroup的联动效果
	 */
	private void setListeners() {
		vpShuCheng.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				((RadioButton)(rgNavigate.getChildAt(arg0))).setChecked(true);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
		rgNavigate.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch(checkedId){
			case R.id.rb_book_store:
				vpShuCheng.setCurrentItem(0);
				break;
			case R.id.rb_book_car:
				vpShuCheng.setCurrentItem(1);
				break;
			case R.id.rb_book_my:
				vpShuCheng.setCurrentItem(2);
				break;
			}
				
			}
		});
	}

	/**
	 * 初始化控件
	 */
	private void setViews() {
		vpShuCheng = (ViewPager) findViewById(R.id.vp_shucheng);
		vpShuCheng.setOffscreenPageLimit(3);
		rgNavigate = (RadioGroup) findViewById(R.id.rg_navigate);
	}

	/**
	 * 保存fragments数据
	 */
	@Override
	public void setAllPageData(List<Fragment> lists) {
		fragments = lists;		
	}

	/**
	 * 显示fragments
	 */
	@Override
	public void displayPagers() {
		adapter = new ShuChengAdapter(getSupportFragmentManager(), fragments);		
		vpShuCheng.setAdapter(adapter);		
	}
	
		
	@Override
	protected void onDestroy() {
		Cart.saveCart();
		super.onDestroy();
	}
	
}
