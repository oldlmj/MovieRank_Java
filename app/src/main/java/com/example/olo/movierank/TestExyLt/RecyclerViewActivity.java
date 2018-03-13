package com.example.olo.movierank.TestExyLt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.olo.movierank.MovieRank.MovieRankFragment;
import com.example.olo.movierank.R;
import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLO on 2018/2/28.
 */

public class RecyclerViewActivity extends Fragment {
    private View mView;
    private String TAG="RecyclerViewActivity";
    private RecyclerView recyclerView;
    private RecyclerViewRecyclerAdapter recyclerViewRecyclerAdapter;
    public static RecyclerViewActivity newInstance(String info) {
        Bundle args = new Bundle();
        RecyclerViewActivity fragment = new RecyclerViewActivity();
        args.putString("RecyclerViewActivity", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = getActivity().getLayoutInflater().inflate(R.layout.test_activity_recycler_view, null, false);
        recyclerView = (RecyclerView) mView.findViewById(R.id.test_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.e(TAG,"onCreate");
        inidata();

    }
    public void inidata(){
        final List<TestItemModel> data = new ArrayList<>();
        data.add(new TestItemModel(
                "0 ACCELERATE_DECELERATE_INTERPOLATOR",
                R.color.material_red_500,
                R.color.material_red_300,
                Utils.createInterpolator(Utils.ACCELERATE_DECELERATE_INTERPOLATOR)));
        data.add(new TestItemModel(
                "1 ACCELERATE_INTERPOLATOR",
                R.color.material_pink_500,
                R.color.material_pink_300,
                Utils.createInterpolator(Utils.ACCELERATE_INTERPOLATOR)));
        data.add(new TestItemModel(
                "2 BOUNCE_INTERPOLATOR",
                R.color.material_purple_500,
                R.color.material_purple_300,
                Utils.createInterpolator(Utils.BOUNCE_INTERPOLATOR)));
        data.add(new TestItemModel(
                "3 DECELERATE_INTERPOLATOR",
                R.color.material_deep_purple_500,
                R.color.material_deep_purple_300,
                Utils.createInterpolator(Utils.DECELERATE_INTERPOLATOR)));
        data.add(new TestItemModel(
                "4 FAST_OUT_LINEAR_IN_INTERPOLATOR",
                R.color.material_indigo_500,
                R.color.material_indigo_300,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new TestItemModel(
                "5 FAST_OUT_SLOW_IN_INTERPOLATOR",
                R.color.material_blue_500,
                R.color.material_blue_300,
                Utils.createInterpolator(Utils.FAST_OUT_SLOW_IN_INTERPOLATOR)));
        data.add(new TestItemModel(
                "6 LINEAR_INTERPOLATOR",
                R.color.material_light_blue_500,
                R.color.material_light_blue_300,
                Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR)));
        data.add(new TestItemModel(
                "7 LINEAR_OUT_SLOW_IN_INTERPOLATOR",
                R.color.material_cyan_500,
                R.color.material_cyan_300,
                Utils.createInterpolator(Utils.LINEAR_OUT_SLOW_IN_INTERPOLATOR)));

        recyclerViewRecyclerAdapter = new RecyclerViewRecyclerAdapter(data);
        recyclerView.setAdapter(recyclerViewRecyclerAdapter);
        Log.e(TAG,"inidata");

    }
}

