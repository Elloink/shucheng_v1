package com.yanxiaobo.shucheng.v1.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.yanxiaobo.shucheng.v1.entity.Cart;
import com.yanxiaobo.shucheng.v1.entity.User;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class DangApplication extends Application{
	private static DangApplication app;
	private static RequestQueue myQueue;
	private static Cart cart;
	
	private static ImageLoader loader;
	
	private static String JSESSIONID;
	private static User user;
	private String token;
	
	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		DangApplication.user = user;
	}

	@Override
	public void onCreate() {
		app = this;
		myQueue = Volley.newRequestQueue(this);
		cart = Cart.readCart();
		loader = new ImageLoader(myQueue, new BitmapCache());
		super.onCreate();
	}
	
	public static DangApplication getApp(){
		return app;
	}
	public static RequestQueue getRequestQueue(){
		return myQueue;
	}
	public static Cart getCart(){
		return cart;
	}
	public static ImageLoader getImageLoader(){
		return loader;
	}
	
	public static String getJSESSIONID() {
		return JSESSIONID;
	}

	public static void setJSESSIONID(String jSESSIONID) {
		JSESSIONID = jSESSIONID;
	}
	/**
	 * token的永久化存储
	 * @param token
	 */
	public void saveToken(String token){
		this.token = token;
		SharedPreferences shared = app.getSharedPreferences("token",Context.MODE_PRIVATE); 
		Editor editor = shared.edit();
		editor.putString("token", token);
		editor.commit();
	}
	/**
	 * token的读取
	 */
	public String readToken(){
		SharedPreferences sdf = app.getSharedPreferences("token", MODE_PRIVATE);
		token = sdf.getString("token", null);
		return token;
	}
	
	/**
	 * 应用程序缓存
	 * @author tarena
	 *
	 */
	private class BitmapCache implements ImageCache{
		private LruCache<String, Bitmap> cache;
		private int max = 10*1024*1024;
		public BitmapCache() {
			cache = new LruCache<String, Bitmap>(max){
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return value.getByteCount();
				}
			};
			
		}
		@Override
		public Bitmap getBitmap(String url) {
			return cache.get(url);
		}

		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			cache.put(url, bitmap);
		}		
	}
}
