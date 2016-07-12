package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.List;


import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IAddressModel;
import com.yanxiaobo.shucheng.v1.model.ICartModel;
import com.yanxiaobo.shucheng.v1.model.IOrderModel;

public class OrderModel implements IOrderModel {
	private IAddressModel addressModel;
	private ICartModel cartModel;
	public OrderModel(){
		addressModel = new AddressModel();
		cartModel = new CartModel();
	}
	@Override
	public void findDefaultAddress(final CommandCallBack callback) {
		addressModel.loadAddressList(new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				@SuppressWarnings("unchecked")
				List<Address> lists = (List<Address>) obj;
				for (Address address : lists) {
					if(address.getIs_default()==1){
						callback.onDataLoad(address);
						return;
					}
				}
			}
		});
		
	}
	@Override
	public void loadCartItemList(CommandCallBack callback) {
		List<Item> lists = cartModel.getAllItem();
		callback.onDataLoad(lists);
	}

}
