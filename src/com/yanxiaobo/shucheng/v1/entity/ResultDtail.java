package com.yanxiaobo.shucheng.v1.entity;


public class ResultDtail {
	private int code;
	private BookDtail data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public BookDtail getData() {
		return data;
	}
	public void setData(BookDtail data) {
		this.data = data;
	}
	public ResultDtail(int code, BookDtail data) {
		super();
		this.code = code;
		this.data = data;
	}
	public ResultDtail() {
		super();
	}
	@Override
	public String toString() {
		return "ResultDtail [code=" + code + ", data=" + data + "]";
	}
	
	
}
