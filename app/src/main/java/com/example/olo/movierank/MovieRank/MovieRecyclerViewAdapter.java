package com.example.olo.movierank.MovieRank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olo.movierank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLO on 2018/2/26.
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRankViewHolder> {
    private List<MovieJsoup> titleItemList = new ArrayList<>();
    private Context context;
    private List<String> titleList=new ArrayList<>();

    public MovieRecyclerViewAdapter(Context context, List<MovieJsoup> titleItemList){
        this.context = context;
        this.titleItemList = titleItemList;
        int i;
        for ( i= 0; i < this.titleItemList.size(); i++) {
            titleList.add(titleItemList.get(i).getTitle());
        }

        Log.d("TAG", "tf1 RecyclerViewAdapter");
    }

    @Override
    public MovieRankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieRankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_rank_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MovieRankViewHolder holder, int position) {
        holder.titleText.setText(titleItemList.get(position).getTitle());
        holder.mUrlString=titleItemList.get(position).getLink();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MovieRankWebViewClient.class);
                intent.putExtra(MovieRankWebViewClient.EXTRA_NAME,holder.mUrlString);
                context.startActivity(intent);
            }
        });
        Log.d("TAG", "RecyclerViewAdapter tf1 onBindViewHolder"+holder.mUrlString);
    }

    @Override
    public int getItemCount() {
        return titleItemList.size();
    }

}

