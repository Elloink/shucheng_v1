package com.yanxiaobo.shucheng.v1.precenter;

public interface IRegistPrecenter {
	void loadImageCode();
	void regist(String email,String password,String nickname,String code);
}
