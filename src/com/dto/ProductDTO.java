package com.dto;

public class ProductDTO {
	private String sCode;
	private String sCategory;
	private String sName;
	private int sPrice;
	private String sContent;
	private String sImage;
	
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String sCode, String sCategory, String sName, int sPrice, String sContent, String sImage) {
		super();
		this.sCode = sCode;
		this.sCategory = sCategory;
		this.sName = sName;
		this.sPrice = sPrice;
		this.sContent = sContent;
		this.sImage = sImage;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getsCategory() {
		return sCategory;
	}

	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
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

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsImage() {
		return sImage;
	}

	public void setsImage(String sImage) {
		this.sImage = sImage;
	}

	@Override
	public String toString() {
		return "ProductDTO [sCode=" + sCode + ", sCategory=" + sCategory + ", sName=" + sName + ", sPrice=" + sPrice
				+ ", sContent=" + sContent + ", sImage=" + sImage + "]";
	}
}
