package com.yanxiaobo.shucheng.v1.entity;

import java.util.List;

public class Result {
	private int code;
	private List<Book> data;
	public Result(int code, List<Book> data) {
		super();
		this.code = code;
		this.data = data;
	}
	public Result() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Book> getData() {
		return data;
	}
	public void setData(List<Book> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", data=" + data + "]";
	}
	
	
}
