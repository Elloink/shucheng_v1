package com.yanxiaobo.shucheng.v1.model;

public interface IRegistModel {
	void loadImageCode(CommandCallBack callback);

	void regist(String email, String password, String nickname, String code,CommandCallBack callback);
}
