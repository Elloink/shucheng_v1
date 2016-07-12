package com.yanxiaobo.shucheng.v1.entity;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private long add_time;
	private double dangPrice;
	private double fixedPrice;
	private int has_deleted;
	private int printTime;
	private long publishTime;
	private String author;
	private String author_summary;
	private String catalogue;
	private String description;
	private String isbn;
	private String keywords;
	private String printNumber;
	private String productName;
	private String product_pic;
	private String publishedTime;
	private String publishing;
	private String totalPage;
	private String whichEdtion;
	private String wordNumber;
	public Book(int id, long add_time, double dangPrice, double fixedPrice,
			int has_deleted, int printTime, long publishTime, String author,
			String author_summary, String catalogue, String description,
			String isbn, String keywords, String printNumber,
			String productName, String product_pic, String publishedTime,
			String publishing, String totalPage, String whichEdtion,
			String wordNumber) {
		super();
		this.id = id;
		this.add_time = add_time;
		this.dangPrice = dangPrice;
		this.fixedPrice = fixedPrice;
		this.has_deleted = has_deleted;
		this.printTime = printTime;
		this.publishTime = publishTime;
		this.author = author;
		this.author_summary = author_summary;
		this.catalogue = catalogue;
		this.description = description;
		this.isbn = isbn;
		this.keywords = keywords;
		this.printNumber = printNumber;
		this.productName = productName;
		this.product_pic = product_pic;
		this.publishedTime = publishedTime;
		this.publishing = publishing;
		this.totalPage = totalPage;
		this.whichEdtion = whichEdtion;
		this.wordNumber = wordNumber;
	}
	public Book() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public int getHas_deleted() {
		return has_deleted;
	}
	public void setHas_deleted(int has_deleted) {
		this.has_deleted = has_deleted;
	}
	public int getPrintTime() {
		return printTime;
	}
	public void setPrintTime(int printTime) {
		this.printTime = printTime;
	}
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor_summary() {
		return author_summary;
	}
	public void setAuthor_summary(String author_summary) {
		this.author_summary = author_summary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getPrintNumber() {
		return printNumber;
	}
	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	public String getPublishedTime() {
		return publishedTime;
	}
	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String getWhichEdtion() {
		return whichEdtion;
	}
	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}
	public String getWordNumber() {
		return wordNumber;
	}
	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", add_time=" + add_time + ", dangPrice="
				+ dangPrice + ", fixedPrice=" + fixedPrice + ", has_deleted="
				+ has_deleted + ", printTime=" + printTime + ", publishTime="
				+ publishTime + ", author=" + author + ", author_summary="
				+ author_summary + ", catalogue=" + catalogue
				+ ", description=" + description + ", isbn=" + isbn
				+ ", keywords=" + keywords + ", printNumber=" + printNumber
				+ ", productName=" + productName + ", product_pic="
				+ product_pic + ", publishedTime=" + publishedTime
				+ ", publishing=" + publishing + ", totalPage=" + totalPage
				+ ", whichEdtion=" + whichEdtion + ", wordNumber=" + wordNumber
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
