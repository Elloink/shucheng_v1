package com.yanxiaobo.shucheng.v1.precenter.impl;

import android.graphics.Bitmap;

import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.entity.BookDtail;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IBookDtaiModel;
import com.yanxiaobo.shucheng.v1.model.impl.BookDtaiModel;
import com.yanxiaobo.shucheng.v1.precenter.IBookDtailPrecenter;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;
import com.yanxiaobo.shucheng.v1.view.IBookDtailView;

public class BookDtailPrecenter implements IBookDtailPrecenter,UrlFactory{
	private IBookDtaiModel model;
	private IBookDtailView view;
	private Book book;
	
	public BookDtailPrecenter(){};

	public BookDtailPrecenter(IBookDtailView view) {
		super();
		model = new BookDtaiModel();
		this.view = view;
	}

	@Override
	public void loadBookDtailById(Book book) {
		this.book = book;
		//2.下载图书详细信息
		model.loadBookDtail(book.getId(), new CommandCallBack() {
			@Override
			public void onDataLoad(Object obj) {
				BookDtail bookDtail = (BookDtail) obj;
				view.setTextMessage(bookDtail);
				model.loadBookPicture(BOOK_PHOTO_URI+bookDtail.getProduct_pic(), new CommandCallBack() {
					@Override
					public void onDataLoad(Object obj) {
						Bitmap bmp = (Bitmap) obj;						
						view.setBackPicture(bmp);
						view.setFrontPicture(bmp);
					}
				});
			}
		});
		
		setAddButton();
	}
	@Override
	public void addToCart(Book book) {
		model.addToCart(book);		
	}

	@Override
	public void setAddButton() {
		boolean isExist = model.checkedBookExist(book);
		
		view.setAddButton(isExist);
	}

}
