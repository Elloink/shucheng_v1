package com.yanxiaobo.shucheng.v1.view;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Item;

public interface ICartView {
	void displayCartItem(List<Item> items);
	void updateCartItem(List<Item> items);
}
