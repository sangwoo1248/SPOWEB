package com.dto;

public class OrderDTO {
	
	private int num;
	private String userid;
	private String sCode;
	private String sName;
	private int sPrice;
	private String sSize;
	private String sColor;
	private int sAmount;
	private String sImage;
	private String orderName;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String payMethod;
	private String orderday;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int num, String userid, String sCode, String sName, int sPrice, String sSize, String sColor,
			int sAmount, String sImage, String orderName, String post, String addr1, String addr2, String phone,
			String payMethod, String orderday) {
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
		this.orderName = orderName;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.payMethod = payMethod;
		this.orderday = orderday;
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

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getOrderday() {
		return orderday;
	}

	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}

	@Override
	public String toString() {
		return "OrderDTO [num=" + num + ", userid=" + userid + ", sCode=" + sCode + ", sName=" + sName + ", sPrice="
				+ sPrice + ", sSize=" + sSize + ", sColor=" + sColor + ", sAmount=" + sAmount + ", sImage=" + sImage
				+ ", orderName=" + orderName + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone="
				+ phone + ", payMethod=" + payMethod + ", orderday=" + orderday + "]";
	}
	

	
	
	
	
}
