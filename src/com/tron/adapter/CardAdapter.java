package com.tron.adapter;

import java.util.List;

import com.Sucre.qrscandemo.R;
import com.tron.javabean.Card;
import com.tron.javabean.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardAdapter extends ArrayAdapter<Card> {

	private int resourseId;
	public CardAdapter(Context context, int resource,List<Card> objects) {
		super(context, resource, objects);
		resourseId=resource;
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		Card card = getItem(position); // 获取当前项的实例
		View view ;
		ViewHolder viewHolder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourseId, null);
		viewHolder=new ViewHolder();
		viewHolder.setCardImage((ImageView) view.findViewById(R.id.card_image));
		viewHolder.setCardId((TextView) view.findViewById(R.id.cardId));
		viewHolder.setCardName((TextView) view.findViewById(R.id.card_name));
		view.setTag(viewHolder);
		}
		else
		{	view = convertView;
		viewHolder=(ViewHolder)view.getTag();
		}
		/*ImageView cardImage = (ImageView) view.findViewById(R.id.card_image);
		TextView cardName = (TextView) view.findViewById(R.id.card_name);
		TextView cardId = (TextView) view.findViewById(R.id.cardId);*/
		viewHolder.getCardImage().setImageResource(card.getImageId());
		viewHolder.getCardName().setText(card.getCardName());
		viewHolder.getCardId().setText(card.getCardId());
		return view;
	}
	

}
