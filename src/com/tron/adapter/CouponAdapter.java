package com.tron.adapter;

import java.util.List;

import com.Sucre.qrscandemo.R;
import com.tron.javabean.Card;
import com.tron.javabean.Coupon;
import com.tron.javabean.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CouponAdapter extends ArrayAdapter<Coupon> {

	private int resourseId;
	public CouponAdapter(Context context, int resource,List<Coupon> objects) {
		super(context, resource, objects);
		resourseId=resource;
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		Coupon coupon = getItem(position); // 获取当前项的实例
		View view ;
		ViewHolder viewHolder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourseId, null);
		viewHolder=new ViewHolder();
		viewHolder.setCouponImage((ImageView) view.findViewById(R.id.coupon_image));
		viewHolder.setCouponId((TextView) view.findViewById(R.id.couponId));
		viewHolder.setCouponName((TextView) view.findViewById(R.id.coupon_name));
		view.setTag(viewHolder);
		}
		else
		{	view = convertView;
		viewHolder=(ViewHolder)view.getTag();
		}
		/*ImageView cardImage = (ImageView) view.findViewById(R.id.card_image);
		TextView cardName = (TextView) view.findViewById(R.id.card_name);
		TextView cardId = (TextView) view.findViewById(R.id.cardId);*/
		viewHolder.getCouponImage().setImageResource(coupon.getImageId());
		viewHolder.getCouponName().setText(coupon.getCouponName());
		viewHolder.getCouponId().setText(coupon.getCouponId());
		return view;
	}
}
