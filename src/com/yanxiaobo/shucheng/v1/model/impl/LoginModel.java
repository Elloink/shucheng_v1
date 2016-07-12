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
import com.yanxiaobo.shucheng.v1.activity.RegistActivity;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.consts.Consts;
import com.yanxiaobo.shucheng.v1.entity.ResultUser;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.ILoginModel;
import com.yanxiaobo.shucheng.v1.utils.CommandRequest;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class LoginModel implements ILoginModel,Consts,UrlFactory{

	@Override
	public void startRegistPager(Activity activity) {
		Intent intent = new Intent(activity, RegistActivity.class);
		activity.startActivityForResult(intent, START_REGISTPAGER_RESPONSE);
	}

	@Override
	public void login(final String email, final String password, final CommandCallBack callback) {
		CommandRequest rqt = new CommandRequest(Method.POST, LOGIN_URI, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					int code = object.getInt("code");
					if(code==1001){
						Gson gson = new Gson();
						ResultUser result = gson.fromJson(response, ResultUser.class);
						DangApplication.getApp().saveToken(result.getToken());
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

			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("email", email);
				map.put("password", password);
				return map;
			}
		};

		DangApplication.getRequestQueue().add(rqt);
	}

}
