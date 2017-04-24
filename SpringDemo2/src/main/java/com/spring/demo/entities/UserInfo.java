package com.spring.demo.entities;

import org.springframework.web.multipart.MultipartFile;

public class UserInfo {

	private String account;
	private String password;
	private MultipartFile userImg;

	public UserInfo() {
	}

	public UserInfo(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getUserImg() {
		return userImg;
	}

	public void setUserImg(MultipartFile userImg) {
		this.userImg = userImg;
	}

}
