package com.xxwade.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.xxwade.house.adapter.HouseAdapter;


public class HouseFragment extends Fragment {
	
	private HouseAdapter houseAdapter;
	private ListView	 houseList;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.house_layout,container, false);
		
		initHouseList(rootView);		
		
		return rootView;
	}
	
	private void initHouseList(View rootView){
		houseList = (ListView)rootView.findViewById(R.id.house_list);
		houseAdapter = new HouseAdapter(getActivity(),getData(),R.layout.house_list_item);
		houseList.setAdapter(houseAdapter);
		
//		houseAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.house_list_item, new String[]{"img","name","address","phone"}, new int[]{R.id.preview,R.id.name,R.id.address,R.id.phone});  
//	    setListAdapter(houseAdapter);  
//		houseAdapter.notifyDataSetChanged();
	}
	
	
	private List<Map<String,Object>> getData(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("img", R.drawable.ylw);
		map.put("name","御龙湾");
		map.put("address", "江苏省丹阳市新民中路61号");
		map.put("phone", "051186732888");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.jxxc);
		map.put("name","锦绣熙城");
		map.put("address", "江苏省丹阳市新民中路61号");
		map.put("phone", "051186559555");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.lxhd);
		map.put("name","领秀花都");
		map.put("address", "江苏省丹阳市新民中路61号");
		map.put("phone", "051186571398");
		list.add(map);
		
		return list;
	}

}
