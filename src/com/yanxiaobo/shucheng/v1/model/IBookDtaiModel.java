package com.yanxiaobo.shucheng.v1.model;

import com.yanxiaobo.shucheng.v1.entity.Book;

public interface IBookDtaiModel {
	void loadBookDtail(int bookId,CommandCallBack callback);
	void loadBookPicture(String url,CommandCallBack callback);
	void addToCart(Book book);
	boolean checkedBookExist(Book book);
}
