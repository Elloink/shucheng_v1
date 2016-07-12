package com.yanxiaobo.shucheng.v1.model.impl;

import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Result;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IStoreModel;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class StoreModel implements IStoreModel,UrlFactory{

	@Override
	public void loadRecommendBook(final CommandCallBack callback) {
		String url = RECOMMEND_BOOK_URI;		
		loadBooks(callback, url);
	}
	
	@Override
	public void loadHotBook(CommandCallBack callback) {
		String url = HOT_BOOK_URI;
		loadBooks(callback, url);		
	}

	@Override
	public void loadNewBook(CommandCallBack callback) {
		String url = NEW_BOOK_URI;
		loadBooks(callback, url);	
	}
	
	public void loadBooks(final CommandCallBack callback, String url) {
		Listener<String> listener = new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Result result = gson.fromJson(response, Result.class);
				//System.out.println(result);
				callback.onDataLoad(result.getData());
			}
		};
		ErrorListener errorListener = new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(DangApplication.getApp(),
						"获取数据失败", Toast.LENGTH_SHORT).show();
			}
		};
		StringRequest rqt = new StringRequest(url,listener,errorListener);
		DangApplication.getRequestQueue().add(rqt);
	}

}
