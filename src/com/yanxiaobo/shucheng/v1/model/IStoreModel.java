package com.yanxiaobo.shucheng.v1.model;

public interface IStoreModel {
	void loadRecommendBook(CommandCallBack callback);
	void loadHotBook(CommandCallBack callback);
	void loadNewBook(CommandCallBack callback);
}
