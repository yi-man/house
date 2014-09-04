package com.xxwade.house.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xxwade.house.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseAdapter extends BaseAdapter{
	
	private Context	context;//运行上下文
	private LayoutInflater	listContainer;//视图容器
	private int	itemViewResource;//自定义项视图源 
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
//	private int[]	img = new int[]{
//			R.drawable.ylw,
//			R.drawable.jxxc,
//			R.drawable.lxhd
//	};
//	private String[] name = new String[]{"御龙湾","锦绣熙城","领秀花都"};
//	private String[] address = new String[]{"江苏省丹阳市新民中路61号","江苏省丹阳市新民中路61号","江苏省丹阳市新民中路61号"};
//	private String[] phone	= new String[]{"051186732888","051186559555","051186571398"};
	
	public HouseAdapter(Context context, List<Map<String, Object>> data, int resource) {
		this.context = context;			
		this.listContainer = LayoutInflater.from(context);	//创建视图容器并设置上下文
		this.itemViewResource = resource;
		list = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ListItemView  listItemView = null;
		
		if (convertView == null) {
			//获取list_item布局文件的视图
			convertView = listContainer.inflate(this.itemViewResource, null);
			
			listItemView = new ListItemView();
			//获取控件对象
			listItemView.img = (ImageView)convertView.findViewById(R.id.preview);
			listItemView.name = (TextView)convertView.findViewById(R.id.name);
			listItemView.address = (TextView)convertView.findViewById(R.id.address);
			listItemView.phone= (TextView)convertView.findViewById(R.id.phone);
		
			
			//设置控件集到convertView
			convertView.setTag(listItemView);
		}else {
			listItemView = (ListItemView)convertView.getTag();
		}	
		
		Map<String, Object> data = list.get(position);
		
		//设置文字和图片
		listItemView.img.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), (Integer)data.get("img")));
		listItemView.name.setText(data.get("name").toString());
		listItemView.address.setText(data.get("address").toString());
		listItemView.phone.setText(data.get("phone").toString());
		
		
		return convertView;
	}
	
	
	static class ListItemView{
		public ImageView img;
		public TextView name;  
	    public TextView address;
	    public TextView phone;	   
	}

}
