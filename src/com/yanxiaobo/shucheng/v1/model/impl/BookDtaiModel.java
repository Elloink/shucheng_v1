package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.entity.ResultDtail;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IBookDtaiModel;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class BookDtaiModel implements IBookDtaiModel,UrlFactory{

	@Override
	public void loadBookDtail(int bookId,final CommandCallBack callback) {
		String url = SEARCH_BOOK_URI+"?id="+bookId;
		System.out.println(url);
		StringRequest rqt = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				ResultDtail rd = gson.fromJson(response, ResultDtail.class);
				callback.onDataLoad(rd.getData());				
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(DangApplication.getApp(), "Õº È–≈œ¢œ¬‘ÿ ß∞‹", Toast.LENGTH_SHORT).show();				
			}
		});
		DangApplication.getRequestQueue().add(rqt);
	}

	@Override
	public void loadBookPicture(String url, final CommandCallBack callback) {
		ImageRequest rqt = new ImageRequest(url, new Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				callback.onDataLoad(response);				
			}
		}, 77, 110, Config.ARGB_8888, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(DangApplication.getApp(), "Õº∆¨œ¬‘ÿ ß∞‹", Toast.LENGTH_SHORT).show();
			}
		});
		DangApplication.getRequestQueue().add(rqt);
	}

	@Override
	public void addToCart(Book book) {
		DangApplication.getCart().buy(book);		
	}

	@Override
	public boolean checkedBookExist(Book book) {
		List<Item> items = DangApplication.getCart().getLists();
		for (Item item : items) {
			if(item.getBook().equals(book)){
				return true;
			}
		}
		return false;
	}

}
