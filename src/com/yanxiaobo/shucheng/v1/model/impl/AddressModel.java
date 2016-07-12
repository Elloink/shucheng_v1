package com.yanxiaobo.shucheng.v1.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.entity.ResultAddress;
import com.yanxiaobo.shucheng.v1.model.CommandCallBack;
import com.yanxiaobo.shucheng.v1.model.IAddressModel;
import com.yanxiaobo.shucheng.v1.utils.CommandRequest;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class AddressModel implements IAddressModel ,UrlFactory{

	@Override
	public void loadAddressList(final CommandCallBack callback) {
		CommandRequest rqt = new CommandRequest(Method.GET, ALL_ADDRESS_URI, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					int code = object.getInt("code");
					if(code==1001){
						Gson gson = new Gson();
						ResultAddress result = gson.fromJson(response, ResultAddress.class);
						callback.onDataLoad(result.getData());
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				
			}
		});
		
		DangApplication.getRequestQueue().add(rqt);
		
	}

	@Override
	public void addNewAddress(final Address address, final CommandCallBack callback) {
		CommandRequest rqt = new CommandRequest(Method.POST, ADD_ADDRESS_URI, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				JSONObject object;
				try {
					object = new JSONObject(response);
					int code = object.getInt("code");
					if(code==1001){
						callback.onDataLoad(null);
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
				
				map.put("address.receiveName", address.getReceiveName());
				map.put("address.full_address",address.getFull_address());
				map.put("address.postalCode",address.getPostalCode());
				map.put("address.mobile",address.getMobile());
				map.put("address.phone",address.getPhone()); 
				return map;
			}
		};
		
		DangApplication.getRequestQueue().add(rqt);
		
	}

	@Override
	public void setDefaultAddress(int id, final CommandCallBack callback) {
		CommandRequest rqt = new CommandRequest(Method.GET, SET_DEFAULT_ADDRESS_URI+"?id="+id, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				try {
					JSONObject object = new JSONObject(response);
					int code = object.getInt("code");
					if(code==1001){
						callback.onDataLoad(null);
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
		});
		DangApplication.getRequestQueue().add(rqt);
	}

}
