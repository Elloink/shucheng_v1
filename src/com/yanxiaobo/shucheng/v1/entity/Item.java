package com.yanxiaobo.shucheng.v1.entity;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private int number;
	public Item(Book book, int number) {
		super();
		this.book = book;
		this.number = number;
	}
	public Item() {
		super();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getItemTotalPrice(){
		return book.getDangPrice()*number;
	}
	@Override
	public String toString() {
		return "Item [book=" + book + ", number=" + number + "]";
	}
	
	
}
