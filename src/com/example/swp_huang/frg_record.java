package com.example.swp_huang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class frg_record extends Fragment
{
	private static final String CHARGE = "charge";
	private static final String PUBLISHCARDNO = "publishCardNO";
	private static final String STATUS = "status";
	private static final String TIME = "time";
	
	private ListView list = null;
	private List<Map<String, String>> listData = new ArrayList<Map<String, String>>();
	private myAdapter adapter; 
	
	private View view = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		if(null == view)
		{
			view = inflater.inflate(R.layout.frg_record_layout, container, false);
			FindView(view);
			InitView();
			System.out.println("3");
		}
		
		ViewGroup parent = (ViewGroup)view.getParent();
		if(null != parent)
		{
			//parent.removeView(view);
		}
		//return super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}
	
	/**
	 * 初始化控件
	 * @param view
	 */
	private void FindView(View view)
	{
		list = (ListView) view.findViewById(R.id.lv_record);
	}

	/**
	 * 初始化控件事件
	 */
	private void InitView()
	{
		adapter = new myAdapter(GetData());
		list.setAdapter(adapter);
		list.invalidate();
		
	}
	
	/**
	 * 获取数据
	 * @return List<Map<String, String>>
	 */
	private List<Map<String, String>> GetData()
	{
		List<Map<String, String>> templist = null;
		
		
		Map<String, String> map1 = new HashMap<String, String>();
		templist = new ArrayList<Map<String, String>>();
		map1.put(CHARGE, getString(R.string.charge_money_record));
		map1.put(PUBLISHCARDNO, getString(R.string.PulbishCardNO_record));
		map1.put(STATUS, getString(R.string.status_record));
		map1.put(TIME, getString(R.string.time_record));

		templist.add(map1);
			
		Map<String, String> map2 = new HashMap<String, String>();
		templist = new ArrayList<Map<String, String>>();
		map2.put(CHARGE, getString(R.string.charge_money_record));
		map2.put(PUBLISHCARDNO, getString(R.string.PulbishCardNO_record));
		map2.put(STATUS, getString(R.string.status_record));
		map2.put(TIME, getString(R.string.time_record));

		templist.add(map2);	
		return templist;
	}
	
	class Holder
	{
		ImageButton ib_delete = null;
		ImageButton ib_refund = null;
		TextView tv_charge = null;
		TextView tv_PublishCardNO = null;
		TextView tv_status = null;
		TextView tv_time = null;
	}
	
	class myAdapter extends BaseAdapter
	{
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		public myAdapter(List<Map<String, String>> list)
		{
			this.list = list;
		}
		
		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public Object getItem(int position)
		{
			return list.get(position);
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			Holder holder = null;
			
			if(null == convertView)
			{
				holder = new Holder();
				
				System.out.println("record" + parent.getContext());
				//convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem_record, parent, false);
				convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem_record_cardview, parent, false);
				
				holder.ib_delete = (ImageButton) convertView.findViewById(R.id.ib_delete);
				holder.ib_refund = (ImageButton) convertView.findViewById(R.id.ib_refund);
				holder.tv_charge = (TextView) convertView.findViewById(R.id.tv_charge);
				holder.tv_PublishCardNO = (TextView) convertView.findViewById(R.id.tv_PublishCardNO);
				holder.tv_status = (TextView) convertView.findViewById(R.id.tv_status);
				holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			
				convertView.setTag(holder);
			}
			
			holder = (Holder) convertView.getTag();
			
			SetView(holder, position);
			EnableView(holder, position, list.get(position).get(STATUS));
			InitClick(holder);
			
			return convertView;
		}
		
		/**
		 * 设置显示内容
		 * @param holder
		 * @param position
		 */
		private void SetView(Holder holder, int position)
		{
			holder.tv_charge.setText(list.get(position).get(CHARGE));
			holder.tv_PublishCardNO.setText(list.get(position).get(PUBLISHCARDNO));
			holder.tv_status.setText(list.get(position).get(STATUS));
			holder.tv_time.setText(list.get(position).get(TIME));
		}
		
		/**(
		 * 根据状态设置 删除、退款 按钮有效状态 以及可见性
		 * @param holder
		 * @param position
		 * @param Status
		 */
		private void EnableView(Holder holder, int position, String Status)
		{
			
		}
		
		/**
		 * 初始化删除、退款 按钮 监听事件
		 * @param holder
		 */
		private void InitClick(Holder holder)
		{
			holder.ib_delete.setOnClickListener(new OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{
					// TODO Auto-generated method stub
					
				}
			});
			
			holder.ib_refund.setOnClickListener(new OnClickListener()
			{
				
				@Override
				public void onClick(View v)
				{
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
	
}
