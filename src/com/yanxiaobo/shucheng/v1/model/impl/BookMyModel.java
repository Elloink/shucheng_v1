package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yanxiaobo.shucheng.v1.activity.LoginActivity;
import com.yanxiaobo.shucheng.v1.activity.MyAddressActivity;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.consts.Consts;
import com.yanxiaobo.shucheng.v1.entity.ResultUser;
import com.yanxiaobo.shucheng.v1.fragment.BookMy;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IBookMyModel;
import com.yanxiaobo.shucheng.v1.utils.CommandRequest;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class BookMyModel implements IBookMyModel,Consts,UrlFactory{

	/**
	 * 启动登录界面
	 */
	@Override
	public void startLoginPager(Activity activity,BookMy bookMy) {
		Intent intent = new Intent(activity, LoginActivity.class);		
		bookMy.startActivityForResult(intent, START_LOGINPAGER_RESPONSE);
	}

	
	/**
	 * 7天自动登录业务
	 */
	@Override
	public void loginAuto(final CommandCallBack callback) {
		CommandRequest rqt = new CommandRequest(Method.POST, LOGIN_AUTO_URI, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				JSONObject object;
				try {
					object = new JSONObject(response);
					int code = object.getInt("code");
					if(code==1001){
						Gson gson = new Gson();
						ResultUser result = gson.fromJson(response, ResultUser.class);
						DangApplication.setUser(result.getUser());
						callback.onDataLoad(result);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("token", DangApplication.getApp().readToken());
				return map;
			}
		};

		DangApplication.getRequestQueue().add(rqt);

	}
	/**
	 * 启动地址管理页面
	 */
	@Override
	public void startAddressPager(Activity activity) {
		Intent intent = new Intent(activity, MyAddressActivity.class);
		activity.startActivity(intent);		
	}
}
