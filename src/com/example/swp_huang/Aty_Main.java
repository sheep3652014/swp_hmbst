package com.example.swp_huang;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnGenericMotionListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Aty_Main extends FragmentActivity
{
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private  FragmentTabHost tabhost;
	
	private GestureDetector gesture = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.aty_main_layout);
		
		FindView();
		IniteGesture();
		//InitView();
	}
	
	@SuppressLint("NewApi")
	private void IniteGesture()
	{
		
		gesture = new GestureDetector(Aty_Main.this, new myTouchListener());
		
	}
	
	class myTouchListener implements OnGestureListener
	{
			
			@Override
			public boolean onSingleTapUp(MotionEvent e)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "onsingleTapup", Toast.LENGTH_SHORT).show();
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "onshowpress", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "onscroll", Toast.LENGTH_SHORT).show();
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "onlongpress", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "onfling", Toast.LENGTH_SHORT).show();
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e)
			{
				// TODO Auto-generated method stub
				Toast.makeText(Aty_Main.this, "ondown", Toast.LENGTH_SHORT).show();
				return false;
			}
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO Auto-generated method stub
		System.out.println("ontouch");
		return gesture.onTouchEvent(event);//super.onTouchEvent(event);
	}

	/**
	 * …Ë÷√tabhost
	 */
	private void FindView()
	{
		tabhost = (FragmentTabHost) findViewById(R.id.tabhost);
		tabhost.setup(Aty_Main.this, getSupportFragmentManager(),R.id.realtabcontent);
		
		TabSpec tabSpec1 = tabhost.newTabSpec(getString(R.string.tab1))
								 .setIndicator(getString(R.string.tab1));
		
		TabSpec tabSpec2 = tabhost.newTabSpec(getString(R.string.tab2))
				.setIndicator(getString(R.string.tab2));
		
		TabSpec tabSpec3 = tabhost.newTabSpec(getString(R.string.tab3))
				//.setContent(new Intent(Aty_Main.this, frg_record.class))  //for Activity
				.setIndicator(getString(R.string.tab3));
						  
		tabhost.addTab(tabSpec1, frg_home.class, null);
		tabhost.addTab(tabSpec2, frg_consume.class, null);
		tabhost.addTab(tabSpec3, frg_record.class, null);
//		tabhost.addTab(tabSpec1);
//		tabhost.addTab(tabSpec2);
//		tabhost.addTab(tabSpec3);
	}



	
	/*private float x_old,y_old, x_new, y_new;
	private void InitView()
	{
		tabhost.setOnTabChangedListener(new OnTabChangeListener()
		{
			
			@Override
			public void onTabChanged(String tabId)
			{
				// TODO Auto-generated method stub
				System.out.println("tabid = " + tabId);
			}
		});
		tabhost.setOnTouchListener(new OnTouchListener()
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getAction())
				{
					case MotionEvent.ACTION_DOWN:
						x_old = event.getRawX();
						y_old = event.getRawY();
						System.out.println("touch down");
						break;
//					case MotionEvent.ACTION_MOVE:
//						x_new = event.getX();
//						y_new = event.getY();
//						System.out.println("touch move");
//						break;
					case MotionEvent.ACTION_UP:
						x_new = event.getRawX(); 
						y_new = event.getRawY();
						System.out.println("touch up");
						int myint = DirctionJudge(x_old, y_old, x_new, y_new);
						if(RIGHT == myint)
						{
							System.out.println("right");
						}
						else if(LEFT == myint)
						{
							System.out.println("left");
						}
						break;
					default:
						break;
				}
				//System.out.println("touch");
				return true;
			}
		});
	}
	
	private int DirctionJudge(float x_old, float y_old, float x_new, float y_new)
	{
		float x,y;
		x = (x_new - x_old);
		y = (y_new - y_old);
		System.out.println(""+x_old+"_"+y_old+","+x_new+"_"+y_new + ","+Math.abs(x) +","+Math.abs(y));
		
		if((4*Math.abs(y) < Math.abs(x)) && (Math.abs(x) > 10))
		{
			if(x > 0)
			{
				return RIGHT; 
			}
			else
			{
				return LEFT;
			}
		}
		
		return 0;
	}*/
}
