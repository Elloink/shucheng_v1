package com.yanxiaobo.shucheng.v1.precenter.impl;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IAddressModel;
import com.yanxiaobo.shucheng.v1.model.impl.AddressModel;
import com.yanxiaobo.shucheng.v1.precenter.IAddressPrecenter;
import com.yanxiaobo.shucheng.v1.view.IAddressView;

public class AddressPrecenter implements IAddressPrecenter {
	
	private IAddressModel model;
	private IAddressView  view;
	
	public AddressPrecenter(IAddressView  view) {
		this.view = view;
		model = new AddressModel();
	}

	@Override
	public void getAddressList() {
		model.loadAddressList(new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				@SuppressWarnings("unchecked")
				List<Address> lists = (List<Address>) obj;
				view.setData(lists);
				view.displayAddressList();
			}
		});
	}

	@Override
	public void addNewAddress(Address address) {
		model.addNewAddress(address,new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				view.dismissDialog();
				getAddressList();
			}
		});
		
	}

	@Override
	public void setDefaultAddress(int id) {
		model.setDefaultAddress(id,new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				getAddressList();
			}
		});
	}
	

}
