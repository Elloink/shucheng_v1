package com.yanxiaobo.shucheng.v1.view;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.Item;

public interface IOrderView {

	void setDefaultAddress(Address address);

	void displayCartList(List<Item> lists);

}
