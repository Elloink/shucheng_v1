package com.yanxiaobo.shucheng.v1.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.adapter.OrderAdapter;
import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.precenter.IOrderPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.OrderPrecenter;
import com.yanxiaobo.shucheng.v1.view.IOrderView;

public class OrderActivity extends Activity implements IOrderView,OnClickListener{
	private IOrderPrecenter precenter;
	
	private TextView tvDefaultAdd;
	private ImageView ivChangeAdd;
	
	private ListView lvOrderCartList;
	private OrderAdapter adapter;
	
	private TextView tvTotalPrice;
	private Button  btSubmit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		setViews();
		precenter = new OrderPrecenter(this);
		precenter.getCartItemList();
		setListeners();
	}
	@Override
	protected void onResume() {
		precenter.getDefaultAddress();
		super.onResume();
	}
	/**
	 * 初始化控件
	 */
	private void setViews() {
		tvDefaultAdd = (TextView) findViewById(R.id.tv_address_info_fulladdrss);
		ivChangeAdd = (ImageView) findViewById(R.id.iv_address_info_changeadd);
		lvOrderCartList = (ListView) findViewById(R.id.lv_order_cart_list);
		tvTotalPrice = (TextView) findViewById(R.id.tv_bottom_info_total_price);
		btSubmit = (Button) findViewById(R.id.bt_order_submit);
		
	}
	/**
	 * 设置监听
	 */
	private void setListeners(){
		ivChangeAdd.setOnClickListener(this);
		btSubmit.setOnClickListener(this);
		btSubmit.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					System.out.println("onTouchEvent事件触发");
					break;
				}
				return true;
			}
		});
	}
	@Override
	public void setDefaultAddress(Address address) {
		String source = "收件人：<font color='red'>&#160&#160"+address.getReceiveName()+"</font><br/>" +
				        "地&#160&#160&#160&#160址：<font color='red'>&#160&#160"+address.getFull_address()+"</font><br/>" +
						"电&#160&#160&#160&#160话：<font color='red'>&#160  "+address.getMobile()+"</font>";
		tvDefaultAdd.setText(Html.fromHtml(source ));
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.iv_address_info_changeadd:
			Intent intent = new Intent(this, MyAddressActivity.class);
			startActivity(intent);
			break;
		case R.id.bt_order_submit:
			System.out.println("onClick事件触发");
			//precenter.submitOrder();
			break;
		}
	}
	@Override
	public void displayCartList(List<Item> lists) {
		adapter = new OrderAdapter(this,lists);
		lvOrderCartList.setAdapter(adapter);
		double sum = 0;
		int    number = 0;
		for (Item item : lists) {
			sum += item.getItemTotalPrice();
			number += item.getNumber();
		}
		String source = "共<font color='red'> "+number+" </font>件,总金额<font color='red'> ￥"+sum+"</font>";
		tvTotalPrice.setText(Html.fromHtml(source ));
	}


}
