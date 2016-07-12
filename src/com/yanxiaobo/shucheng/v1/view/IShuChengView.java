package com.yanxiaobo.shucheng.v1.view;

import java.util.List;

import android.support.v4.app.Fragment;

public interface IShuChengView {
	void setAllPageData(List<Fragment> lists);
	void displayPagers();
}
