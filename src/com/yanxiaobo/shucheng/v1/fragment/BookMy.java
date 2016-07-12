package com.yanxiaobo.shucheng.v1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.app.DangApplication;
import com.yanxiaobo.shucheng.v1.precenter.IBookMyPrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.BookMyPrecenter;
import com.yanxiaobo.shucheng.v1.ui.CircleImageView;
import com.yanxiaobo.shucheng.v1.view.IBookMyView;

public class BookMy extends Fragment implements IBookMyView,OnClickListener{
	private IBookMyPrecenter precenter;
	private View view;
	
	private CircleImageView cvHeader;
	private TextView tvNickName;
	private TextView tvAddress;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_my_fragment, null);
		setViews();
		setListeners();
		precenter = new BookMyPrecenter(this);
		if(DangApplication.getApp().readToken()!=null){
			precenter.loginAuto();			
		}
		return view;
	}
	
	/**
	 * ��ʼ���ؼ�
	 */
	private void setViews(){
		cvHeader = (CircleImageView) view.findViewById(R.id.iv_my_header);
		tvNickName = (TextView) view.findViewById(R.id.tv_my_user_nickname);
		tvAddress = (TextView) view.findViewById(R.id.tv_myaddress);
	}
	/**
	 * ���ü���
	 */
	private void setListeners(){
		cvHeader.setOnClickListener(this);
		tvAddress.setOnClickListener(this);		
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("�յ�����login�������Ϣ����");
		updateUser();
	}

	/**
	 * �����û�����
	 */
	@Override
	public void updateUser() {
		tvNickName.setText(DangApplication.getUser().getNickname());
	}

	/**
	 * ������Ӧ����
	 * @param v
	 */
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.iv_my_header:
			precenter.startLoginPager(getActivity(),BookMy.this);
			break;
		case R.id.tv_myaddress:
			if(DangApplication.getUser()!=null){
				precenter.startAddressPager(getActivity());				
			}else{
				Toast.makeText(getActivity(), "���ȵ�¼", Toast.LENGTH_SHORT).show();
				precenter.startLoginPager(getActivity(),BookMy.this);				
			}
			break;
		}
	}
	
	
}
