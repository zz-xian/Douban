package com.xiaoxian.demo.douban;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListRefreshFragment extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_refresh_fragment,container,false);
        refreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(android.R.color.holo_red_light,android.R.color.holo_green_light,android.R.color.holo_blue_bright);
        lv=(ListView)view.findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getData()));
        return view;
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               refreshLayout.setRefreshing(false);
            }
        },3000);
    }

    public List<String> getData(){
        List<String> data=new ArrayList<String>();
        for (int i=0;i<=20;i++){
            data.add(String.valueOf(i));//可用i+""
        }
        return data;
    }
}
