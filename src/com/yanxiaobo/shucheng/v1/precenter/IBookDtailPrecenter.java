package com.yanxiaobo.shucheng.v1.precenter;

import com.yanxiaobo.shucheng.v1.entity.Book;

public interface IBookDtailPrecenter {
	void loadBookDtailById(Book book);
	void addToCart(Book book);
	void setAddButton();
}
