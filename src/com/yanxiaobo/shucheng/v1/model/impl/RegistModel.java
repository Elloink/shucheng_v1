package com.yanxiaobo.shucheng.v1.model.impl;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IRegistModel;
import com.yanxiaobo.shucheng.v1.utils.CommandRequest;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class RegistModel implements IRegistModel,UrlFactory{
	
	/**
	 * 下载验证码图片，并获取JSESSIONID;
	 */
	@Override
	public void loadImageCode(final CommandCallBack callback) {
		ImageRequest rqt = new ImageRequest(IMAGE_CODE_URI, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap response) {
				callback.onDataLoad(response);
			}
		}, 130, 50, Config.ARGB_8888, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(DangApplication.getApp(), "下载验证码失败", Toast.LENGTH_SHORT).show();
			}
		}){
			@Override
			protected Response<Bitmap> parseNetworkResponse(
					NetworkResponse response) {
				Map<String, String> map = response.headers;
				System.out.println(map.get("Set-Cookie"));
				DangApplication.setJSESSIONID(map.get("Set-Cookie").split(";")[0]);
				return super.parseNetworkResponse(response);
			}
		};
		DangApplication.getRequestQueue().add(rqt);
	}

	/**
	 * 注册业务
	 */
	@Override
	public void regist(final String email, final String password, final String nickname,
			final String code,final CommandCallBack callback) {
		if(email==null||password==null||nickname==null||code==null){
			Toast.makeText(DangApplication.getApp(), "请填写完整用户信息", Toast.LENGTH_SHORT).show();
			return;
		}
		CommandRequest rqt = new CommandRequest(Method.POST, REGIST_URI, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					int resultCode = object.getInt("code");
					if(resultCode==1001){
						Toast.makeText(DangApplication.getApp(), "注册成功", Toast.LENGTH_SHORT).show();
						callback.onDataLoad(resultCode);
					}else{
						Toast.makeText(DangApplication.getApp(), "注册失败："+object.getString("error_msg"), Toast.LENGTH_SHORT).show();
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
				map.put("user.email", email);
				map.put("user.nickname", nickname);
				map.put("user.password", password);
				map.put("number", code);
				return map;
			}
		};
		DangApplication.getRequestQueue().add(rqt);		
	}
	
	/**
	 * 登录业务
	 */
	
}
