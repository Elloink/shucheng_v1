package com.yanxiaobo.shucheng.v1.entity;

public class ResultUser {
	private int code;
	private User user;
	private String token;
	public ResultUser(int code, User user, String token) {
		super();
		this.code = code;
		this.user = user;
		this.token = token;
	}
	public ResultUser() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "ResultUser [code=" + code + ", user=" + user + ", token="
				+ token + "]";
	}
	
	
}
