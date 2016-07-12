package com.yanxiaobo.shucheng.v1.entity;

import java.util.List;

public class ResultAddress {
	private int code;
	private List<Address> data;
	public ResultAddress(int code, List<Address> data) {
		super();
		this.code = code;
		this.data = data;
	}
	public ResultAddress() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Address> getData() {
		return data;
	}
	public void setData(List<Address> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultAddress [code=" + code + ", data=" + data + "]";
	}
	
	
}
