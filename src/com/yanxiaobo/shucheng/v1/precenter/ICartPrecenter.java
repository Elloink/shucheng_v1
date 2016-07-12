package com.yanxiaobo.shucheng.v1.precenter;

import com.yanxiaobo.shucheng.v1.entity.Item;

public interface ICartPrecenter {
	void loadCart();
	void updateCart();
	double getTotalPrice();
	void deleteItem(Item item);
}
