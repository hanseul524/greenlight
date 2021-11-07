package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class Category {
	private int categoryNo;
	private String chCategory;
	private Date chStartDate;
	
	public Category() {}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getChCategory() {
		return chCategory;
	}

	public void setChCategory(String chCategory) {
		this.chCategory = chCategory;
	}

	public Date getChStartDate() {
		return chStartDate;
	}

	public void setChStartDate(Date chStartDate) {
		this.chStartDate = chStartDate;
	}

	@Override
	public String toString() {
		return "Category [카테고리번호=" + categoryNo + ", 카테고리명=" + chCategory + ", 시작일=" + chStartDate
				+ "]";
	}
	
}
