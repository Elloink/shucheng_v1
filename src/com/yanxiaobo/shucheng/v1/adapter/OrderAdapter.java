package com.yanxiaobo.shucheng.v1.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderAdapter extends BaseAdapter implements UrlFactory{
	private Context context;
	private List<Item> lists;
	public OrderAdapter(Context context, List<Item> lists) {
		this.context = context;
		this.lists = lists;
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Item getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Item item = getItem(position);
		Book book = item.getBook();
		ViewHolder holder = null;
		if(convertView==null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.order_cart_list_format, null);
			holder = new ViewHolder();
			holder.ivPicture = (ImageView) convertView.findViewById(R.id.iv_order_list_picture);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_order_book_title);
			holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_order_book_price);
			holder.tvNumber = (TextView) convertView.findViewById(R.id.tv_order_book_number);
			holder.tvTotalPrice = (TextView) convertView.findViewById(R.id.tv_order_item_price);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.tvTitle.setText(book.getProductName());
		holder.tvPrice.setText("гд"+book.getDangPrice()+"");
		holder.tvNumber.setText("x "+item.getNumber());
		holder.tvTotalPrice.setText("гд"+item.getItemTotalPrice());
		ImageLoader loader = DangApplication.getImageLoader();
		ImageListener listener = ImageLoader.getImageListener(holder.ivPicture, R.drawable.small, R.drawable.small);
		loader.get(BOOK_PHOTO_URI+book.getProduct_pic(), listener);
		return convertView;
	}
	
	class ViewHolder{
		ImageView ivPicture;
		TextView tvTitle;
		TextView tvPrice;
		TextView tvNumber;
		TextView tvTotalPrice;
	}

}
