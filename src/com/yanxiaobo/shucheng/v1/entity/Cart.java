package com.yanxiaobo.shucheng.v1.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import com.yanxiaobo.shucheng.v1.app.DangApplication;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> lists = new ArrayList<Item>();
	
	public Cart() {
		super();
		lists = new ArrayList<Item>();
	}

	public void setLists(List<Item> lists) {
		this.lists = lists;
	}

	public List<Item> getLists() {
		return lists;
	}
	
	/**
	 * ��ӹ�����
	 * @return
	 */
	public  boolean buy(Book book){
		for (Item item : lists) {
			if(item.getBook().equals(book)){
				return false;
			}			
		}
		Item item = new Item(book, 1);
		lists.add(item);
		return true;
	}
	/**
	 * ɾ��������
	 * @param item
	 * @return
	 */
	public  boolean delete(Item item){
		return lists.remove(item);		
	}
	/**
	 * ���ӹ�������
	 * @param position
	 */
	public  void add(int position){
		Item item = lists.get(position);
		item.setNumber(item.getNumber()+1);		
	}
	/**
	 * ���ٹ�������
	 * @param position
	 */
	public void sub(int position){
		Item item = lists.get(position);
		if(item.getNumber()==0){
			return;
		}
		item.setNumber(item.getNumber()-1);		
	}
	
	public String cartToString(){
		StringBuilder sb = new StringBuilder();
		for (Item item : lists) {
			sb.append(item.getBook().getId()+","+item.getNumber()+";");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	/**
	 * �����ܼ۸�
	 * @return
	 */
	public double getTotalPrice(){
		double totalPrice = 0;
		for (Item item : lists) {
			totalPrice += item.getBook().getDangPrice()*item.getNumber();
		}
		return totalPrice;
	}
	
	/**
	 * ���ﳵ��������û��洢
	 */
	public static void saveCart() {
		//1.���õ����ﳵ����cart
		Cart cart = DangApplication.getCart();
		//2.��cartд��cache
		File file = new File(DangApplication.getApp().getCacheDir(), "cart.obj");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cart);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ﳵ�Ķ�ȡ
	 */
	public static  Cart readCart(){
		//1.�ȶ�ȡ��cart
		Cart cart = null;
		File file = new File(DangApplication.getApp().getCacheDir(), "cart.obj");
		if(file.exists()){
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				cart = (Cart) ois.readObject();
				ois.close();
			} catch (StreamCorruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//2.��cart����ֵ��APPliacation
		if(cart!=null){
			return cart;
		}else{
			return new Cart();
		}
	}
}
