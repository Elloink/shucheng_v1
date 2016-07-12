package com.yanxiaobo.shucheng.v1.precenter;

import com.yanxiaobo.shucheng.v1.entity.Address;

public interface IAddressPrecenter {

	void getAddressList();

	void addNewAddress(Address address);

	void setDefaultAddress(int id);

}
