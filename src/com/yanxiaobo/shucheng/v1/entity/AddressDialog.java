package com.yanxiaobo.shucheng.v1.entity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.precenter.IAddressPrecenter;


public class AddressDialog extends Dialog{
	
	private EditText etReceiver;
	private EditText etFullAddress;
	private EditText etPostCode;
	private EditText etMobile;
	private EditText etPhone;
	private Button btAdd;
	
	private Address address;
	private IAddressPrecenter precenter;
	
	public AddressDialog(Context context,IAddressPrecenter precenter) {
		super(context);
		this.precenter = precenter;
	}
	/**
	 * 重写dialog的show()方法。
	 * 
	 */
	@Override
	public void show() {
		super.show();
		Window window = getWindow();
		window.setContentView(R.layout.add_new_address_fomat);
		window.setBackgroundDrawable(new ColorDrawable(0x00000000));
		setViews(window);
		setListeners();
	}
	
	/**
	 * 设置监听
	 */
	private void setListeners() {
		btAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				address = collectAddressInfo();
				precenter.addNewAddress(address);
			}
		});
		
	}
	protected Address collectAddressInfo() {
		Address address = new Address();
		address.setReceiveName(etReceiver.getText().toString().trim());
		address.setFull_address(etFullAddress.getText().toString().trim());
		address.setPostalCode(etPostCode.getText().toString().trim());
		address.setMobile(etMobile.getText().toString().trim());
		address.setPhone(etPhone.getText().toString().trim());
		return address;
	}
	/**
	 * 控件初始化
	 * @param window
	 */
	private void setViews(Window window) {
		etReceiver = (EditText) window.findViewById(R.id.et_add_address_receiver);
		etFullAddress = (EditText) window.findViewById(R.id.et_add_address_address);
		etPostCode = (EditText) window.findViewById(R.id.et_add_address_postcode);
		etMobile = (EditText) window.findViewById(R.id.et_add_address_mobile);
		etPhone = (EditText) window.findViewById(R.id.et_add_address_phone);
		btAdd = (Button) window.findViewById(R.id.bt_add_new_address);
	}
}
