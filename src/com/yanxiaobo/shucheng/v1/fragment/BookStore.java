package com.yanxiaobo.shucheng.v1.fragment;

import java.util.List;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.adapter.StoreAdapter;
import com.yanxiaobo.shucheng.v1.entity.Book;
import com.yanxiaobo.shucheng.v1.precenter.IStorePrecenter;
import com.yanxiaobo.shucheng.v1.precenter.impl.StorePrecenter;
import com.yanxiaobo.shucheng.v1.view.IStoreView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class BookStore extends Fragment implements IStoreView,OnItemClickListener{
	private View view;
	
	private IStorePrecenter storePrecenter;
	//编辑推荐
	private List<Book>   recommendBooks;
	private StoreAdapter recommendAdapter;	
	private GridView     gvRecommendBook; 
	//热销推荐
	private List<Book>   hotBooks;
	private StoreAdapter hotAdapter;	
	private GridView     gvHotBook; 
	//新书推荐
	private List<Book>   newBooks;
	private StoreAdapter newAdapter;	
	private GridView     gvNewBook; 
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.book_store_fragment, null);
		setViews();
		storePrecenter = new StorePrecenter(this);
		storePrecenter.loadRecommendBook();
		storePrecenter.loadHotBook();
		storePrecenter.loadNewBook();
		setListeners();
		return view;
	}
	private void setViews() {
		gvRecommendBook = (GridView) view.findViewById(R.id.gv_edittor_recommend);
		gvHotBook = (GridView) view.findViewById(R.id.gv_hot_books);
		gvNewBook = (GridView) view.findViewById(R.id.gv_new_books);
		
	}
	private void setListeners(){
		gvRecommendBook.setOnItemClickListener(this);
		gvHotBook.setOnItemClickListener(this);
		gvNewBook.setOnItemClickListener(this);
	}
	@Override
	public void displayRecommendBook(List<Book> books) {
		recommendBooks = books;
		this.recommendAdapter = new StoreAdapter(recommendBooks, getActivity());
		gvRecommendBook.setAdapter(recommendAdapter);
		
	}
	@Override
	public void displayHotBook(List<Book> books) {
		hotBooks = books;
		this.hotAdapter = new StoreAdapter(hotBooks, getActivity());
		gvHotBook.setAdapter(hotAdapter);		
	}
	@Override
	public void displayNewBook(List<Book> books) {
		newBooks = books;
		this.newAdapter = new StoreAdapter(newBooks, getActivity());
		gvNewBook.setAdapter(newAdapter);
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Book book = null;
		switch(parent.getId()){
		case R.id.gv_edittor_recommend:
			book = recommendBooks.get(position);
			break;
		case R.id.gv_hot_books:
			book = hotBooks.get(position);
			break;
		case R.id.gv_new_books:
			book = newBooks.get(position);
			break;
		}		
		storePrecenter.displayBookDtail(getActivity(), book);
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
}
