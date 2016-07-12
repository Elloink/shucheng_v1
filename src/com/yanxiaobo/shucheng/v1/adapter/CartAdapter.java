package com.yanxiaobo.shucheng.v1.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.entity.Item;
import com.yanxiaobo.shucheng.v1.precenter.ICartPrecenter;
import com.yanxiaobo.shucheng.v1.utils.UrlFactory;

public class CartAdapter extends BaseAdapter implements UrlFactory{
	private List<Item> lists;
	private Context context;
	private ICartPrecenter precenter;
	
	public CartAdapter(List<Item> lists, Context context,ICartPrecenter precenter) {
		super();
		this.lists = lists;
		this.context = context;
		this.precenter = precenter;		
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
		final Item item = getItem(position);
		Book book = item.getBook();
		ViewHolder holder = null;
		if(convertView==null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.cart_list_format, null);
			holder = new ViewHolder();
			holder.ivDelete = (ImageView) convertView.findViewById(R.id.iv_cart_list_delete);
			holder.ivPicture = (ImageView) convertView.findViewById(R.id.iv_cart_list_picture);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_book_title);
			holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_book_price);
			holder.tvNumber = (TextView) convertView.findViewById(R.id.tv_book_number);
			holder.ivAdd = (ImageView) convertView.findViewById(R.id.iv_add);
			holder.ivSub = (ImageView) convertView.findViewById(R.id.iv_sub);
			holder.tvNumber2 = (TextView) convertView.findViewById(R.id.tv_number);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		
		holder.tvTitle.setText(book.getProductName());
		holder.tvPrice.setText(book.getDangPrice()+"");
		holder.tvNumber.setText("x"+item.getNumber());
		holder.tvNumber2.setText(item.getNumber()+"");
		
		holder.ivAdd.setOnClickListener(new InnerOnClickListener(item));
		holder.ivSub.setOnClickListener(new InnerOnClickListener(item));
		holder.ivDelete.setOnClickListener(new InnerOnClickListener(item));		
		
		ImageListener listener = ImageLoader.getImageListener(holder.ivPicture, R.drawable.small,R.drawable.small);
		DangApplication.getImageLoader().get(BOOK_PHOTO_URI+book.getProduct_pic(), listener);
		
		return convertView;
	}

	class ViewHolder{
		ImageView ivDelete;
		ImageView ivPicture;
		TextView  tvTitle;
		TextView  tvPrice;
		TextView  tvNumber;
		TextView  tvNumber2;
		ImageView ivAdd;
		ImageView ivSub;
	}
	
	class InnerOnClickListener implements OnClickListener{
		private Item item;
		public InnerOnClickListener(Item item){
			this.item = item;
		}
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.iv_add:
				item.setNumber(item.getNumber()+1);
				break;
			case R.id.iv_sub:
				if(item.getNumber()==1){
					break;
				}
				item.setNumber(item.getNumber()-1);
				break;
			case R.id.iv_cart_list_delete:
				precenter.deleteItem(item);				
				break;
			}
			precenter.updateCart();			
		}
		
	}
}
