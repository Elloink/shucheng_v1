package com.yanxiaobo.shucheng.v1.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.adapter.AddressAdapter;
import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.AddressDialog;
import com.yanxiaobo.shucheng.v1.precenter.IAddressPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.AddressPrecenter;
import com.yanxiaobo.shucheng.v1.view.IAddressView;

public class MyAddressActivity extends Activity implements IAddressView{
	
	private TextView tvNewAdd;
	private ListView lvAddressList;
	private List<Address> adds;
	private AddressAdapter adapter;
	private IAddressPrecenter precenter;
	protected AddressDialog dialog;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_address);
		
		setViews();
		precenter = new AddressPrecenter(this);
		precenter.getAddressList();
		setListeners();
	}
	private void setListeners() {
		tvNewAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog = new AddressDialog(MyAddressActivity.this,precenter);
				dialog.show();
			}
		});
	}
	/**
	 * ³õÊ¼»¯¿Ø¼þ
	 */
	private void setViews() {
		tvNewAdd = (TextView) findViewById(R.id.tv_address_newadd);
		lvAddressList = (ListView) findViewById(R.id.lv_address_list);
	}
	@Override
	public void setData(List<Address> lists) {
		adds = lists;
	}
	@Override
	public void displayAddressList() {
		adapter = new AddressAdapter(this, adds,precenter);
		lvAddressList.setAdapter(adapter);
	}
	@Override
	public void dismissDialog() {
		dialog.dismiss();
	}

	
}
