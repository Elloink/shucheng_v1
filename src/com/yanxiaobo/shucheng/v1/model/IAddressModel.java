package com.yanxiaobo.shucheng.v1.model;

import com.yanxiaobo.shucheng.v1.entity.Address;

public interface IAddressModel {

	void loadAddressList(CommandCallBack callback);

	void addNewAddress(Address address, CommandCallBack callback);

	void setDefaultAddress(int id, CommandCallBack callback);

}
