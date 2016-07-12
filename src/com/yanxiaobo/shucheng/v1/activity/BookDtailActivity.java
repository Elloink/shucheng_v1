package com.yanxiaobo.shucheng.v1.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.entity.BookDtail;
import com.yanxiaobo.shucheng.v1.precenter.IBookDtailPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.BookDtailPrecenter;
import com.yanxiaobo.shucheng.v1.utils.BitmapUtil;
import com.yanxiaobo.shucheng.v1.utils.BitmapUtil.BitmapCallback;
import com.yanxiaobo.shucheng.v1.utils.TimeUtil;
import com.yanxiaobo.shucheng.v1.view.IBookDtailView;

public class BookDtailActivity extends Activity implements IBookDtailView{
	private IBookDtailPrecenter dtailPrecenter;
	
	private ImageView ivBack;
	private ImageView ivFront;
	private TextView  tvTitle;
	private TextView  tvPrice;
	private TextView  tvAuthor;
	//private TextView  tvType;
	private TextView  tvPublishTime;
	private TextView  tvPublishing;
	private TextView  tvDiscrip;
	private Button    btAddToCart;
	
	private Book book;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_dtail);
		setViews();		
		dtailPrecenter = new BookDtailPrecenter(this);		
		dtailPrecenter.loadBookDtailById(getBook());
		setListener();
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void setViews() {
		ivBack = (ImageView) findViewById(R.id.iv_bookdtail_bacpic);
		ivFront = (ImageView) findViewById(R.id.iv_bookdtail_fropic);
		
		tvTitle = (TextView) findViewById(R.id.tv_textmessage_title);
		tvPrice = (TextView) findViewById(R.id.tv_textmessage_price);
		tvAuthor = (TextView) findViewById(R.id.tv_textmessage_author2);
		//tvType = (TextView) findViewById(R.id.tv_textmessage_type2);
		tvPublishTime = (TextView) findViewById(R.id.tv_textmessage_publish2);
		tvPublishing = (TextView) findViewById(R.id.tv_textmessage_publishing2);
		tvDiscrip = (TextView) findViewById(R.id.tv_content_textdtail);
		btAddToCart = (Button) findViewById(R.id.bt_addto_car);
		
	}
	/**
	 * ��ȡһ��ͼ��;
	 * @return Id
	 */	
	private Book getBook() {
		this.book = (Book) getIntent().getSerializableExtra("Book");
		return book;
	} 

	/**
	 * ����ӵ����ﳵ����ť����
	 */
	private void setListener(){
		btAddToCart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.bt_addto_car:
					btAddToCart.setEnabled(false);
					dtailPrecenter.addToCart(book);
					Toast.makeText(BookDtailActivity.this, "��ӳɹ�", Toast.LENGTH_SHORT).show();
					btAddToCart.setText("����ӵ����ﳵ");
					break;
				}				
			}
		});
	}
	/**
	 * 
	 * ���ñ���ͼƬ
	 */
	@Override
	public void setBackPicture(Bitmap bmp) {
		BitmapUtil.loadBluredBitmap(bmp, 20, new BitmapCallback() {
			
			@Override
			public void onBitmapCreat(Bitmap bmp) {
				ivBack.setImageBitmap(bmp);				
			}
		});
		
	}
	/**
	 * ����ǰ��ͼƬ
	 */
	@Override
	public void setFrontPicture(Bitmap bmp) {
		ivFront.setImageBitmap(bmp);		
	}
	/**
	 * �����ı���Ϣ
	 */
	@Override
	public void setTextMessage(BookDtail book) {
		tvTitle.setText(book.getProductName());
		tvPrice.setText(book.getDangPrice()+"��");
		tvAuthor.setText(book.getAuthor());
		tvPublishTime.setText(TimeUtil.getFormatTime(book.getPublishTime()));
		tvPublishing.setText(book.getPublishing());
		tvDiscrip.setText(book.getDescription());		
	}
	
	@Override
	public void setAddButton(boolean isExist) {
		if(isExist){
			btAddToCart.setEnabled(false);
			System.out.println("��ť����Ϊ���ɵ��");
			btAddToCart.setText("����ӵ����ﳵ");
		}else{
			btAddToCart.setEnabled(true);
			btAddToCart.setText("���ﳵ");
		}		
	}
	

}
