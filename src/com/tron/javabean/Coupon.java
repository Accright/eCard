package com.tron.javabean;


public class Coupon { //extends BmobObject 

	/**
	 * 
	 */
	private static final long serialVersionUID = -7614402736936982094L;
	private String couponId;
	private String couponName;
	private int imageId;
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Coupon(String couponId,String couponName, int ImageId)
	{
		this.couponId=couponId;
		this.couponName=couponName;
		this.imageId=ImageId;
	}
}
