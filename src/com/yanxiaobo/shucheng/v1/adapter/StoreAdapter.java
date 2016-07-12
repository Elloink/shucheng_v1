package com.yanxiaobo.shucheng.v1.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreAdapter extends BaseAdapter implements UrlFactory{
	private List<Book> lists;
	private Context context;
	
	public StoreAdapter(List<Book> lists, Context context) {
		super();
		this.lists = lists;
		this.context = context;
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Book getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Book book = getItem(position);
		ViewHolder holder = null;
		if(convertView==null){
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.book_list_format, null); 
			holder.ivPicture = (ImageView) convertView.findViewById(R.id.iv_book_picture);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_book_title);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.tvTitle.setText(book.getProductName());
		ImageListener listener = ImageLoader.getImageListener(holder.ivPicture, R.drawable.ic_launcher, R.drawable.ic_launcher);
		DangApplication.getImageLoader().get(BOOK_PHOTO_URI+book.getProduct_pic(), listener);
		return convertView;		
	}
	
	class ViewHolder{
		ImageView ivPicture;
		TextView  tvTitle;
	}	
}
