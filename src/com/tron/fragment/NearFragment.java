package com.tron.fragment;

import com.Sucre.qrscandemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NearFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View nearLayout=inflater.inflate(R.layout.near_layout,container,false);
		return nearLayout;
	}

	
}
