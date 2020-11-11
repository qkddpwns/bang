package com.bang.myapp.model;

import java.util.Arrays;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberVO {

	private String userId;
	private String passWord;
	private String name;
	private String tel;
	private byte[] picture;
	private long pictureSize;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public long getPictureSize() {
		return pictureSize;
	}
	public void setPictureSize(long pictureSize) {
		this.pictureSize = pictureSize;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", passWord=" + passWord + ", name=" + name + ", tel=" + tel
				+ ", picture=" + Arrays.toString(picture) + ", pictureSize=" + pictureSize + "]";
	}

	
	
}

// vo -> 
