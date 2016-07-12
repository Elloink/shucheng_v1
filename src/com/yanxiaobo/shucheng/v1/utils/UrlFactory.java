package com.yanxiaobo.shucheng.v1.utils;

public interface UrlFactory {
	String RECOMMEND_BOOK_URI = "http://45.78.24.178:8080/dang/main/getrecommend.action";
	String BOOK_PHOTO_URI = "http://45.78.24.178:8080/dang/productImages/";
	String HOT_BOOK_URI = 	"http://45.78.24.178:8080/dang/main/gethot.action";
	String NEW_BOOK_URI = 	"http://45.78.24.178:8080/dang/main/getnew.action";
	String SEARCH_BOOK_URI ="http://45.78.24.178:8080/dang/main/qbook.action";
	String IMAGE_CODE_URI = "http://45.78.24.178:8080/dang/user/getImage.action";
	String REGIST_URI =     "http://45.78.24.178:8080/dang/user/register.action";
	String LOGIN_URI =      "http://45.78.24.178:8080/dang/user/login.action";
	String LOGIN_AUTO_URI = "http://45.78.24.178:8080/dang/user/loginWithoutPwd.action";
	String ALL_ADDRESS_URI= "http://45.78.24.178:8080/dang/order/chooseAdd.action";
	String ADD_ADDRESS_URI= "http://45.78.24.178:8080/dang/order/saveAdd.action";
	String SET_DEFAULT_ADDRESS_URI= "http://45.78.24.178:8080/dang/order/setAddDefault.action";
}
