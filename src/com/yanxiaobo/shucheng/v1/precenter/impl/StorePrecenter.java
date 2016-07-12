package com.yanxiaobo.shucheng.v1.precenter.impl;

import java.util.List;

import android.content.Context;
import android.content.Intent;

import com.yanxiaobo.shucheng.v1.activity.BookDtailActivity;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IStoreModel;
import com.yanxiaobo.shucheng.v1.model.impl.StoreModel;
import com.yanxiaobo.shucheng.v1.precenter.IStorePrecenter;
import com.yanxiaobo.shucheng.v1.view.IStoreView;


public class StorePrecenter implements IStorePrecenter{

	private IStoreModel model;
	private IStoreView view;
	private List<Book> books;
	
	public StorePrecenter(IStoreView view) {
		super();
		this.view = view;
		model = new StoreModel();
	}

	@Override
	public void loadRecommendBook() {
		model.loadRecommendBook(new CommandCallBack() {
			@SuppressWarnings("unchecked")
			@Override
			public void onDataLoad(Object obj) {
				books = (List<Book>) obj;
				view.displayRecommendBook(books);				
			}
		});
		
	}

	@Override
	public void loadHotBook() {
		model.loadHotBook(new CommandCallBack() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onDataLoad(Object obj) {
				books = (List<Book>) obj;
				view.displayHotBook(books);				
			}
		});
		
	}

	@Override
	public void loadNewBook() {
		model.loadNewBook(new CommandCallBack() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onDataLoad(Object obj) {
				books = (List<Book>) obj;
				view.displayNewBook(books);				
			}
		});		
	}

	@Override
	public void displayBookDtail(Context context, Book book) {
		Intent intent = new Intent(context, BookDtailActivity.class);
		intent.putExtra("Book", book);
		context.startActivity(intent);		
	}

}
