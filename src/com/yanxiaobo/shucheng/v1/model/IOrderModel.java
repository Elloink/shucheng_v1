package com.yanxiaobo.shucheng.v1.model;

public interface IOrderModel {

	void findDefaultAddress(CommandCallBack callback);

	void loadCartItemList(CommandCallBack callback);

}
