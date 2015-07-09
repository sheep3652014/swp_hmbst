package com.example.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class ListView_dispatch extends ListView
{


	@SuppressLint("NewApi")
	public ListView_dispatch(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes)
	{
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
	}

	public ListView_dispatch(Context context, AttributeSet attrs,
			int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public ListView_dispatch(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ListView_dispatch(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		// TODO Auto-generated method stub
		return super.onTouchEvent(ev);
	}
	
	
}
