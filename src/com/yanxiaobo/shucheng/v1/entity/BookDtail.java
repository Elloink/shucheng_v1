package com.yanxiaobo.shucheng.v1.entity;

public class BookDtail {
	private long add_time;
	private String author;
	private String author_summary;
	private String catalogue;
	private double dangPrice;
	private String description;
	private double fixedPrice;
	private int has_deleted;
	private int id;
	private String isbnprivate;
	private String keywords;
	private String printNumber;
	private int printTime;
	private String productName;
	private String product_pic;
	private long publishTime;
	private String publishedTime;
	private String publishing;
	private String totalPage;
	private String whichEdtion;
	private String wordNumber;
	public BookDtail() {
		super();
	}
	public BookDtail(long add_time, String author, String author_summary,
			String catalogue, double dangPrice, String description,
			double fixedPrice, int has_deleted, int id, String isbnprivate,
			String keywords, String printNumber, int printTime,
			String productName, String product_pic, long publishTime,
			String publishedTime, String publishing, String totalPage,
			String whichEdtion, String wordNumber) {
		super();
		this.add_time = add_time;
		this.author = author;
		this.author_summary = author_summary;
		this.catalogue = catalogue;
		this.dangPrice = dangPrice;
		this.description = description;
		this.fixedPrice = fixedPrice;
		this.has_deleted = has_deleted;
		this.id = id;
		this.isbnprivate = isbnprivate;
		this.keywords = keywords;
		this.printNumber = printNumber;
		this.printTime = printTime;
		this.productName = productName;
		this.product_pic = product_pic;
		this.publishTime = publishTime;
		this.publishedTime = publishedTime;
		this.publishing = publishing;
		this.totalPage = totalPage;
		this.whichEdtion = whichEdtion;
		this.wordNumber = wordNumber;
	}
	public long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(long add_time) {
		this.add_time = add_time;
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
	public double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbnprivate() {
		return isbnprivate;
	}
	public void setIsbnprivate(String isbnprivate) {
		this.isbnprivate = isbnprivate;
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
	public int getPrintTime() {
		return printTime;
	}
	public void setPrintTime(int printTime) {
		this.printTime = printTime;
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
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
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
		return "BookDtail [add_time=" + add_time + ", author=" + author
				+ ", author_summary=" + author_summary + ", catalogue="
				+ catalogue + ", dangPrice=" + dangPrice + ", description="
				+ description + ", fixedPrice=" + fixedPrice + ", has_deleted="
				+ has_deleted + ", id=" + id + ", isbnprivate=" + isbnprivate
				+ ", keywords=" + keywords + ", printNumber=" + printNumber
				+ ", printTime=" + printTime + ", productName=" + productName
				+ ", product_pic=" + product_pic + ", publishTime="
				+ publishTime + ", publishedTime=" + publishedTime
				+ ", publishing=" + publishing + ", totalPage=" + totalPage
				+ ", whichEdtion=" + whichEdtion + ", wordNumber=" + wordNumber
				+ "]";
	}
	
	
}
