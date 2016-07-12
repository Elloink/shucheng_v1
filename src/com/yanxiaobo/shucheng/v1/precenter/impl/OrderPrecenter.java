package com.yanxiaobo.shucheng.v1.precenter.impl;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IOrderModel;
import com.yanxiaobo.shucheng.v1.model.impl.OrderModel;
import com.yanxiaobo.shucheng.v1.precenter.IOrderPrecenter;
import com.yanxiaobo.shucheng.v1.view.IOrderView;

public class OrderPrecenter implements IOrderPrecenter {
	private IOrderModel model;
	private IOrderView view;
	public OrderPrecenter(IOrderView view) {
		model = new OrderModel();
		this.view = view;
	}
	@Override
	public void getDefaultAddress() {
		model.findDefaultAddress(new CommandCallBack() {
			
			@Override
			public void onDataLoad(Object obj) {
				Address address = (Address) obj;
				view.setDefaultAddress(address);
			}
		});
	}
	@Override
	public void getCartItemList() {
		model.loadCartItemList(new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				@SuppressWarnings("unchecked")
				List<Item> lists = (List<Item>) obj;
				view.displayCartList(lists);
			}
		});
		
	}

}
