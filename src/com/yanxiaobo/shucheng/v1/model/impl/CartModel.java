package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.List;

import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.model.ICartModel;

public class CartModel implements ICartModel{
	
	@Override
	public List<Item> getAllItem() {
		return DangApplication.getCart().getLists();
	}
	@Override
	public double computeTotalPrice() {
		return DangApplication.getCart().getTotalPrice();
	}

	@Override
	public void deleteItem(Item item) {
		DangApplication.getCart().delete(item);
	}
}
