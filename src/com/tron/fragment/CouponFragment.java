package com.tron.fragment;

import java.util.ArrayList;
import java.util.List;

import com.Sucre.qrscandemo.R;
import com.activity.CardDetailActivity;
import com.tron.adapter.CardAdapter;
import com.tron.adapter.CouponAdapter;
import com.tron.javabean.Card;
import com.tron.javabean.Coupon;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class CouponFragment extends ListFragment {

	private List<Coupon> couponList = new ArrayList<Coupon>();
	private CouponAdapter couponAdapter=null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View couponLayout=inflater.inflate(R.layout.coupon_layout,container,false);
		return couponLayout;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initCoupons();
	    couponAdapter = new CouponAdapter(getActivity(),R.layout.couponbean,couponList);
		setListAdapter(couponAdapter);
	}

	private void initCoupons() {
		Log.i("smile", "init coupons");
		Coupon test1 = new Coupon("No.001","优惠券测试1",R.drawable.testcoupon1);
		couponList.add(test1);
		Coupon test2 = new Coupon("No.002","优惠券测试2",R.drawable.testcoupon2);
		couponList.add(test2);
		Coupon test3 = new Coupon("No.003","优惠券测试3",R.drawable.testcoupon3);
		couponList.add(test3);
		Coupon test4 = new Coupon("No.004","优惠券测试4",R.drawable.testcoupon3);
		couponList.add(test4);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Coupon coupon =couponList.get(position);
	/*	Intent qsIntent=new Intent(getActivity(),CouponDetailActivity.class);
		qsIntent.putExtra("qsStringi", coupon.getcouponName()+":"+coupon.getcouponId());
		startActivity(qsIntent);*/
		Toast.makeText(getActivity(),coupon.getCouponName(),
				Toast.LENGTH_SHORT).show();
		super.onListItemClick(l, v, position, id);
	}
	
}
