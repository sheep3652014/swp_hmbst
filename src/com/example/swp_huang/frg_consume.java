package com.example.swp_huang;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.example.listview.ListView_dispatch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class frg_consume extends Fragment
{

	//private ListView lv_consume;
	private Context context;
	
	private ListView_dispatch lv_consume;
	
	private myAdapter adapter = null;
	
	private View view = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		this.context = container.getContext();
		
		if(null == view)
		{
			view = inflater.inflate(R.layout.frg_consume_layout, container, false);
			
			FindView(view);
			InitView();
			System.out.println("2");
		}
		
		ViewGroup parent = (ViewGroup) view.getParent();
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
		//lv_consume = (ListView) view.findViewById(R.id.lv_consume);
		lv_consume = (ListView_dispatch) view.findViewById(R.id.lv_consume);
	}
	
	/**
	 * 初始化控件事件
	 */
	private void InitView()
	{
		//GetData();
		adapter = new myAdapter(GetData());
		lv_consume.setAdapter(adapter);
		lv_consume.invalidate();
	}
	
	/**
	 * 获取adapter数据
	 */
	private List<String> GetData()
	{	
		List<String> list = new ArrayList<String>();
		
		list.add("记录0");
		list.add("记录1");
		list.add("记录2");
		list.add("记录3");
		list.add("记录4");
		list.add("记录5");
		list.add("记录6");
		list.add("记录7");
		list.add("记录8");
		list.add("记录9");
		
		return list;
	}
	
	class myAdapter extends BaseAdapter
	{
		List<String> list = new ArrayList<String>();
		
		public myAdapter(List<String> list)
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

		@SuppressLint("NewApi")
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			Holder holder = null;
			
			if(null == convertView)
			{
				holder = new Holder();
				System.out.println("consume" + parent.getContext());
				
				convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem_consume, parent, false);
				
				holder.tv_consume = (TextView) convertView.findViewById(R.id.tv_consume);
				holder.im_type = (ImageView) convertView.findViewById(R.id.im_type);
				
				convertView.setTag(holder);
			}
			holder = (Holder) convertView.getTag();
			
			holder.tv_consume.setText(list.get(position));
			holder.im_type.setBackgroundResource(R.drawable.charge_text);
			
			return convertView;
		}
		
	}
	
	class Holder 
	{
		TextView tv_consume;
		ImageView im_type;
	}
}
