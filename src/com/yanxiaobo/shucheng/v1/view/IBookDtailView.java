package com.yanxiaobo.shucheng.v1.view;

import com.yanxiaobo.shucheng.v1.entity.BookDtail;

import android.graphics.Bitmap;

public interface IBookDtailView {
	void setBackPicture(Bitmap bmp);
	void setFrontPicture(Bitmap bmp);
	void setTextMessage(BookDtail book);
	void setAddButton(boolean isExist);
	
	
}
