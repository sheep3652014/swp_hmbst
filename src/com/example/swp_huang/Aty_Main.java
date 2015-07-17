package com.example.swp_huang;

import java.util.ArrayList;
import java.util.List;

import com.example.fragment_adapter.Frgpager_adapter;
import com.example.listview.ListView_dispatch;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.text.Layout.Alignment;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnGenericMotionListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Aty_Main extends FragmentActivity
{
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private ViewPager viewPager;
	private PagerTabStrip PagerTab;
	private FrameLayout frame_Title;
	private FrameLayout frame_content;
	private FragmentManager fm;
	private FragmentTransaction transaction;
	private List<String> titlelist = new ArrayList<String>();
	private List<Fragment> fragmentlist = new ArrayList<Fragment>();
	
	private GestureDetector gesture = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.aty_main_layout);
		
		FindView();
		Init();
	}
	
	
	private void FindView()
	{
		frame_Title = (FrameLayout) findViewById(R.id.frame_Title);
		viewPager = (ViewPager) findViewById(R.id.ViewPager);
		PagerTab = (PagerTabStrip) findViewById(R.id.PagerTab);
	}
	
	private void Init()
	{
		fm = getSupportFragmentManager();
		transaction = fm.beginTransaction();
		
		transaction.replace(R.id.frame_Title, new frg_title_home());
		//transaction.addToBackStack(null);//ÃÌº”÷¡backstack’ª
		
		InitViewPager(fm);
		
		transaction.commit();
	}
	
	private void InitViewPager(FragmentManager fm)
	{
		String[] titles = getResources().getStringArray(R.array.Title);
		
		PagerTab.setTextColor(getResources().getColor(R.color.l_blue));
		PagerTab.setTabIndicatorColor(getResources().getColor(R.color.l_blue));
		PagerTab.setBackgroundColor(getResources().getColor(R.color.white));
		//PagerTab.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);//newAPI
		
		
		if(titles.length < 3)
		{
			titles[0] = "--";
			titles[1] = "--";
			titles[2] = "--";
		}
		titlelist.add(titles[0]);
		titlelist.add(titles[1]);
		titlelist.add(titles[2]);
		
		Fragment frg_home = new frg_home();
		Fragment frg_consume = new frg_consume();
		Fragment frg_record = new frg_record();
		
		fragmentlist.add(frg_home);
		fragmentlist.add(frg_consume);
		fragmentlist.add(frg_record);
		
		viewPager.setAdapter(new Frgpager_adapter(fm, titlelist, fragmentlist));
		
	}
	
	
}
