package com.yanxiaobo.shucheng.v1.utils;

import java.util.HashMap;
import java.util.Map;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.yanxiaobo.shucheng.v1.app.DangApplication;

public class CommandRequest extends StringRequest{
	
	public CommandRequest(int method, String url, Listener<String> listener,
			ErrorListener errorListener) {
		super(method, url, listener, errorListener);
	}
	
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		Map<String, String> map = new HashMap<String, String>();
		String jsession = DangApplication.getJSESSIONID();
		if(jsession==null){
			return map;
		}else{
			map.put("Cookie", jsession);
		}
		System.out.println(map);
		return map;
	}
	
	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		Map<String, String> map = response.headers;
		String jsession = map.get("Set-Cookie");
		if(jsession!=null){
			jsession = jsession.split(";")[0];
			DangApplication.setJSESSIONID(jsession);
		}
		return super.parseNetworkResponse(response);
	}
	
	
}
