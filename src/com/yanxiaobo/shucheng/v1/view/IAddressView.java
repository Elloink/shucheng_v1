package com.yanxiaobo.shucheng.v1.view;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Address;

public interface IAddressView {

	void setData(List<Address> lists);

	void displayAddressList();


	void dismissDialog();

}
