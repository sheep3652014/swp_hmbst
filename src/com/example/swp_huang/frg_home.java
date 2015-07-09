package com.example.swp_huang;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class frg_home extends Fragment
{

	private Button btn_bigCard;
	private Button btn_SwpCard;
	private TextView tv_Balance;
	private TextView tv_PublishCardNO;
	private TextView tv_ValidDay;
	private TextView tv_PhoneNO;
	
	private Context context;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		this.context = container.getContext();
		
		View view = inflater.inflate(R.layout.frg_home_layout, container, false);
		
		FindView(view);
		InitView();
		System.out.println("1");
		return view;
		//return super.onCreateView(inflater, container, savedInstanceState);
	
	}
	
	/**
	 * 初始化控件
	 * @param view
	 */
	private void FindView(View view)
	{
		btn_bigCard = (Button) view.findViewById(R.id.btn_bigcard);
		btn_SwpCard = (Button) view.findViewById(R.id.btn_swpcard);
		
		tv_Balance = (TextView) view.findViewById(R.id.tv_balance);
		tv_PublishCardNO = (TextView) view.findViewById(R.id.tv_PublishCardNO);
		tv_ValidDay = (TextView) view.findViewById(R.id.tv_ValidDay);
		tv_PhoneNO = (TextView) view.findViewById(R.id.tv_PhoneNO);
	}
	
	/**
	 * 初始化按钮点击事件
	 */
	private void InitView()
	{
		btn_bigCard.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(context, "click bigcard", Toast.LENGTH_SHORT).show();
			}
		});
		
		btn_SwpCard.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(context, "click swpcard", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
