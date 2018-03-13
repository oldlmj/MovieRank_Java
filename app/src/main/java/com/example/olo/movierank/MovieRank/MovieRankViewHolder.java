package com.example.olo.movierank.MovieRank;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.olo.movierank.R;

/**
 * Created by OLO on 2018/2/26.
 */

public class MovieRankViewHolder extends RecyclerView.ViewHolder {

    public TextView titleText, typeText, dateText;
    public String mUrlString;
    public final View mView;
    public MovieRankViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        titleText= (TextView) itemView.findViewById(R.id.rank);
        Log.d("TAG", "ViewHolder ViewHolder(View itemView)");
    }
}
