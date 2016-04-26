package com.tron.javabean;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	ImageView cardImage;
	TextView cardName;
	TextView cardId;
	ImageView couponImage;
	TextView couponName;
	TextView couponId;
	public ImageView getCouponImage() {
		return couponImage;
	}
	public void setCouponImage(ImageView couponImage) {
		this.couponImage = couponImage;
	}
	public TextView getCouponName() {
		return couponName;
	}
	public void setCouponName(TextView couponName) {
		this.couponName = couponName;
	}
	public TextView getCouponId() {
		return couponId;
	}
	public void setCouponId(TextView couponId) {
		this.couponId = couponId;
	}
	public ImageView getCardImage() {
		return cardImage;
	}
	public void setCardImage(ImageView cardImage) {
		this.cardImage = cardImage;
	}
	public TextView getCardName() {
		return cardName;
	}
	public void setCardName(TextView cardName) {
		this.cardName = cardName;
	}
	public TextView getCardId() {
		return cardId;
	}
	public void setCardId(TextView cardId) {
		this.cardId = cardId;
	}
	
}
