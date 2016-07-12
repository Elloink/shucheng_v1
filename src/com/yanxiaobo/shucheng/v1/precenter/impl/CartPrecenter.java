package com.yanxiaobo.shucheng.v1.precenter.impl;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.model.ICartModel;
import com.yanxiaobo.shucheng.v1.model.impl.CartModel;
import com.yanxiaobo.shucheng.v1.precenter.ICartPrecenter;
import com.yanxiaobo.shucheng.v1.view.ICartView;

public class CartPrecenter implements ICartPrecenter{
	private ICartModel model;
	private ICartView  view;
	public CartPrecenter(ICartView view){
		model = new CartModel();
		this.view = view;
	}
	@Override
	public void loadCart() {
		List<Item> items = model.getAllItem();
		view.displayCartItem(items);
	}

	@Override
	public void updateCart() {
		List<Item> items = model.getAllItem();
		view.updateCartItem(items);		
	}
	@Override
	public double getTotalPrice() {
		return model.computeTotalPrice();
	}
	@Override
	public void deleteItem(Item item) {
		model.deleteItem(item);		
	}

}
