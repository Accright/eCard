package com.tron.javabean;

import android.R.integer;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Card  extends BmobObject{//
	
	private String cardId;
	private String cardName;
	private int ImageId;
	private String userId;
	private String shopId;
	private Integer point;
	private Integer discount;
	private BmobFile cardPic;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public BmobFile getCardPic() {
		return cardPic;
	}
	public void setCardPic(BmobFile cardPic) {
		this.cardPic = cardPic;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getImageId() {
		return ImageId;
	}
	public void setImageId(int imageId) {
		ImageId = imageId;
	}
	
	public Card(String cardId,String cardName, int ImageId)
	{
		this.cardId=cardId;
		this.cardName=cardName;
		this.ImageId=ImageId;
	}
	

}
