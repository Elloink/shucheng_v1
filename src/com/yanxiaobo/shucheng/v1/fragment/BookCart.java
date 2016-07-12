package com.yanxiaobo.shucheng.v1.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.activity.OrderActivity;
import com.yanxiaobo.shucheng.v1.adapter.CartAdapter;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.precenter.ICartPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.CartPrecenter;
import com.yanxiaobo.shucheng.v1.view.ICartView;

public class BookCart extends Fragment implements ICartView,OnClickListener{
	private List<Item> items;
	private ICartPrecenter cartPrecenter;
	private CartAdapter adapter;

	private View view;
	private ListView lvCart;
	private TextView tvTotalPrice;
	private TextView tvEdit;
	private Button btSettle;
	private static boolean  isVisible;
	//Item中的View控件
	private ImageView ivDelete;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_cart_fragment, null);
		setViews();
		cartPrecenter = new CartPrecenter(this);
		cartPrecenter.loadCart();
		setListeners();
		return view;
	}

	@Override
	public void onResume() {
		cartPrecenter.updateCart();
		super.onResume();
	}
	
	@Override
	public void onPause() {
		if(items.size()!=0){
			setIvDeleteGone();
		}
		super.onPause();
	}

	/**
	 * 设置监听
	 */
	private void setListeners() {
		tvEdit.setOnClickListener(this);
		btSettle.setOnClickListener(this);
	}
	/**
	 * 删除购物项图标  显示
	 */
	private void setIvDeleteVisible() {
		for (int i = 0; i < items.size(); i++) {
			ivDelete = (ImageView) lvCart.getChildAt(i).findViewById(R.id.iv_cart_list_delete);
			ivDelete.setVisibility(View.VISIBLE);
			isVisible = true;
		}
	}
	/**
	 * 删除购物项图标  隐藏
	 */
	private void setIvDeleteGone(){
		for (int i = 0; i < items.size(); i++) {
			ivDelete = (ImageView) lvCart
					.getChildAt(i)
					.findViewById(R.id.iv_cart_list_delete);
			ivDelete.setVisibility(View.GONE);
			isVisible = false;
		}
	}
	/**
	 * 初始化控件
	 */
	private void setViews() {
		tvEdit = (TextView) view.findViewById(R.id.tv_cart_edit);
		lvCart = (ListView) view.findViewById(R.id.lv_cart_item);		
		tvTotalPrice = (TextView) view.findViewById(R.id.tv_cart_total_price2);
		btSettle = (Button) view.findViewById(R.id.bt_cart_settle);
	}
	/**
	 * 显示购物车内容
	 */
	@Override
	public void displayCartItem(List<Item> items) {
		this.items = items;
		adapter = new CartAdapter(this.items, getActivity(),cartPrecenter);
		lvCart.setAdapter(adapter);
		tvTotalPrice.setText("￥"+cartPrecenter.getTotalPrice());
	}

	/**
	 * 更新购物车信息
	 */
	@Override
	public void updateCartItem(List<Item> items) {
		this.items = items;
		adapter.notifyDataSetChanged();	
		tvTotalPrice.setText("￥"+cartPrecenter.getTotalPrice());
	}
	/**
	 * 设置监听
	 * @param v
	 */
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.tv_cart_edit:
			if(items.size()==0){
				isVisible = false;
				return;
			}
			if(isVisible){
				setIvDeleteGone();
			}else{
				setIvDeleteVisible();
			}
			break;
		case R.id.bt_cart_settle:
			Intent intent = new Intent(getActivity(),OrderActivity.class);
			startActivity(intent);
			break;
		}
	}


}
