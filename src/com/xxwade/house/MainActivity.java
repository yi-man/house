package com.xxwade.house;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。
 * 
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * 用于展示楼盘的Fragment
	 */
	private HouseFragment houseFragment;

	/**
	 * 用于展示文化的Fragment
	 */
	private CultureFragment cultureFragment;

	/**
	 * 用于展示动态的Fragment
	 */
	private NewsFragment newsFragment;


	/**
	 * 楼盘界面布局
	 */
	private View houseLayout;

	/**
	 * 文化界面布局
	 */
	private View cultureLayout;

	/**
	 * 动态界面布局
	 */
	private View newsLayout;


	/**
	 * 在Tab布局上显示楼盘图标的控件
	 */
	private ImageView houseImage;

	/**
	 * 在Tab布局上显示文化图标的控件
	 */
	private ImageView cultureImage;

	/**
	 * 在Tab布局上显示动态图标的控件
	 */
	private ImageView newsImage;


	/**
	 * 在Tab布局上显示楼盘标题的控件
	 */
	private TextView houseText;

	/**
	 * 在Tab布局上显示文化标题的控件
	 */
	private TextView cultureText;

	/**
	 * 在Tab布局上显示动态标题的控件
	 */
	private TextView newsText;


	/**
	 * 用于对Fragment进行管理
	 */
	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// 初始化布局元素
		initViews();
		fragmentManager = getFragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);
	}

	/**
	 * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
	 */
	private void initViews() {
		houseLayout = findViewById(R.id.house_layout);
		cultureLayout = findViewById(R.id.culture_layout);
		newsLayout = findViewById(R.id.news_layout);
		houseImage = (ImageView) findViewById(R.id.house_image);
		cultureImage = (ImageView) findViewById(R.id.culture_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		houseText = (TextView) findViewById(R.id.house_text);
		cultureText = (TextView) findViewById(R.id.culture_text);
		newsText = (TextView) findViewById(R.id.news_text);
		houseLayout.setOnClickListener(this);
		cultureLayout.setOnClickListener(this);
		newsLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.house_layout:
			// 当点击了楼盘tab时，选中第1个tab
			setTabSelection(0);
			break;
		case R.id.news_layout:
			// 当点击了动态tab时，选中第2个tab
			setTabSelection(1);
			break;
		case R.id.culture_layout:
			// 当点击了文化tab时，选中第3个tab
			setTabSelection(2);
			break;		
		default:
			break;
		}
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 *            每个tab页对应的下标。0表示楼盘，1表示新闻，2表示文化。
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了楼盘tab时，改变控件的图片和文字颜色
			houseImage.setImageResource(R.drawable.house);
			houseText.setTextColor(Color.WHITE);
			if (houseFragment == null) {
				// 如果houseFragment为空，则创建一个并添加到界面上
				houseFragment = new HouseFragment();
				transaction.add(R.id.content, houseFragment);
			} else {
				// 如果houseFragment不为空，则直接将它显示出来
				transaction.show(houseFragment);
			}
			break;
		case 1:			
			// 当点击了动态tab时，改变控件的图片和文字颜色
			newsImage.setImageResource(R.drawable.news);
			newsText.setTextColor(Color.WHITE);
			if (newsFragment == null) {
				// 如果NewsFragment为空，则创建一个并添加到界面上
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// 如果NewsFragment不为空，则直接将它显示出来
				transaction.show(newsFragment);
			}
			break;			
		case 2:
			// 当点击了文化tab时，改变控件的图片和文字颜色
			cultureImage.setImageResource(R.drawable.culture);
			cultureText.setTextColor(Color.WHITE);
			if (cultureFragment == null) {
				// 如果cultureFragment为空，则创建一个并添加到界面上
				cultureFragment = new CultureFragment();
				transaction.add(R.id.content, cultureFragment);
			} else {
				// 如果cultureFragment不为空，则直接将它显示出来
				transaction.show(cultureFragment);
			}
			break;
		default:
			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		houseImage.setImageResource(R.drawable.house);
		houseText.setTextColor(Color.parseColor("#82858b"));
		cultureImage.setImageResource(R.drawable.culture);
		cultureText.setTextColor(Color.parseColor("#82858b"));
		newsImage.setImageResource(R.drawable.news);
		newsText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (houseFragment != null) {
			transaction.hide(houseFragment);
		}
		if (cultureFragment != null) {
			transaction.hide(cultureFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
	}
}
