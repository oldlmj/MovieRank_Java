package com.example.olo.movierank.ExpandableListTest;




import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import com.example.olo.movierank.MovieStudios.MovieTheaterArea;
import com.example.olo.movierank.R;

/**
 * Created by OLO on 2018/3/6.
 */

public class ExpandableListViewTest extends Fragment {

    private Context context;
    private ExpandableListView mExpandableListView;
    private String[] groupArray = MovieTheaterArea.localcht;//组列表
    private String[][] childArray = MovieTheaterArea.allmoviestudio;//子列表
    private String[][] childArrayMSUrl =MovieTheaterArea.alllUrl;
    private String TAG = "ExpandableListViewTest";


    public static ExpandableListViewTest newInstance(String info) {
        Bundle args = new Bundle();
        ExpandableListViewTest fragment = new ExpandableListViewTest();
        args.putString("ExpandableListViewTest", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expandablelistview, container, false);
        mExpandableListView =(ExpandableListView)rootView.findViewById(R.id.elst);
        final ExpandableListTestAdapter adapter = new ExpandableListTestAdapter(groupArray, childArray,childArrayMSUrl);

        mExpandableListView.setAdapter(adapter);
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                boolean groupExpanded = parent.isGroupExpanded(groupPosition);
                adapter.setIndicatorState(groupPosition, groupExpanded);
                // 請務必返回 false，否则分组不會展開
                return false;
            }
        });
        // 設置分組項的點擊監聽事件
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                boolean groupExpanded = parent.isGroupExpanded(groupPosition);
                adapter.setIndicatorState(groupPosition, groupExpanded);
                // 請務必返回 false，否则分组不會展開
                return false;
            }
        });
        // 設置子選項點擊監聽事件
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String Url = childArrayMSUrl[groupPosition][childPosition];
                Log.e(TAG,Url);
                Intent intent = new Intent(getContext(), MovieStudioWebClient.class);
                intent.putExtra(MovieStudioWebClient.MovieStudUrl,Url);
                startActivity(intent);
                return true;
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


}
