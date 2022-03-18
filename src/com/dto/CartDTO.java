package com.dto;

public class CartDTO {
	private int num;
	private String userid;
	private String sCode;
	private String sName;
	private int sPrice;
	private String sSize;
	private String sColor;
	private int sAmount;
	private String sImage;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int num, String userid, String sCode, String sName, int sPrice, String sSize, String sColor,
			int sAmount, String sImage) {
		super();
		this.num = num;
		this.userid = userid;
		this.sCode = sCode;
		this.sName = sName;
		this.sPrice = sPrice;
		this.sSize = sSize;
		this.sColor = sColor;
		this.sAmount = sAmount;
		this.sImage = sImage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public String getsSize() {
		return sSize;
	}

	public void setsSize(String sSize) {
		this.sSize = sSize;
	}

	public String getsColor() {
		return sColor;
	}

	public void setsColor(String sColor) {
		this.sColor = sColor;
	}

	public int getsAmount() {
		return sAmount;
	}

	public void setsAmount(int sAmount) {
		this.sAmount = sAmount;
	}

	public String getsImage() {
		return sImage;
	}

	public void setsImage(String sImage) {
		this.sImage = sImage;
	}

	@Override
	public String toString() {
		return "CartDTO [num=" + num + ", userid=" + userid + ", sCode=" + sCode + ", sName=" + sName + ", sPrice="
				+ sPrice + ", sSize=" + sSize + ", sColor=" + sColor + ", sAmount=" + sAmount + ", sImage=" + sImage
				+ "]";
	}

}
