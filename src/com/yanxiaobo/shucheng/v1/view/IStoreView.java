package com.yanxiaobo.shucheng.v1.view;

import java.util.List;

import com.yanxiaobo.shucheng.v1.entity.Book;

public interface IStoreView {
	void displayRecommendBook(List<Book> books);
	void displayHotBook(List<Book> books);
	void displayNewBook(List<Book> books);
}
