package com.yanxiaobo.shucheng.v1.precenter;

import android.content.Context;

import com.yanxiaobo.shucheng.v1.entity.Book;

public interface IStorePrecenter {
	void loadRecommendBook();
	void loadHotBook();
	void loadNewBook();
	void displayBookDtail(Context context,Book book);
}
