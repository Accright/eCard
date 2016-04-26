package com.tron.fragment;

import java.util.ArrayList;
import java.util.List;

import com.Sucre.qrscandemo.R;
import com.activity.CardDetailActivity;
import com.activity.MainActivity;
import com.trin.resideMenu.ResideMenu;
import com.tron.adapter.CardAdapter;
import com.tron.javabean.Card;

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

public class CardFragment extends ListFragment {

	private List<Card> cardList = new ArrayList<Card>();
	private CardAdapter cardAdapter=null;
	
//	private ResideMenu resideMenu;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View cardLayout=inflater.inflate(R.layout.card_layout,container,false);
//		setUpViews();
//		ListView listView=(ListView)cardLayout.findViewById(R.id.card_listview);
		return cardLayout;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initCards();
	    cardAdapter= new CardAdapter(getActivity(),R.layout.cardbean,cardList);
		setListAdapter(cardAdapter);
	}

	private void initCards() {
		Log.i("smile", "init cards");
		Card test1 = new Card("No.00001","TestCard_1",R.drawable.testcard1);
		cardList.add(test1);
		Card test2 = new Card("No.00002","TestCard_2",R.drawable.testcard2);
		cardList.add(test2);
		Card test3 = new Card("No.00003","TestCard_3",R.drawable.testcard3);
		cardList.add(test3);
		Card test4 = new Card("No.00004","TestCard_4",R.drawable.testcard3);
		cardList.add(test4);
		Card test5 = new Card("No.00005","TestCard_5",R.drawable.testcard2);
		cardList.add(test5);
		Card test6 = new Card("No.00006","TestCard_6",R.drawable.testcard1);
		cardList.add(test6);
		Card test7 = new Card("No.00007","TestCard_7",R.drawable.testcard3);
		cardList.add(test7);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Card card =cardList.get(position);
		Intent qsIntent=new Intent(getActivity(),CardDetailActivity.class);
		qsIntent.putExtra("qsStringi", card.getCardName()+":"+card.getCardId());
		startActivity(qsIntent);
/*		Toast.makeText(getActivity(),card.getCardName(),
				Toast.LENGTH_SHORT).show();*/
		super.onListItemClick(l, v, position, id);
	}
	
	/*public void setUpViews()
	{
		MainActivity parentActivity = (MainActivity) getActivity();
		resideMenu = parentActivity.getResideMenu();
	}*/
}
