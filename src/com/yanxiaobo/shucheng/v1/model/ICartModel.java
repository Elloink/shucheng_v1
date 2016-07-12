package com.yanxiaobo.shucheng.v1.model;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Item;

public interface ICartModel {
	List<Item> getAllItem();
	double computeTotalPrice();
	void deleteItem(Item item);
}
