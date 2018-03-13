package com.example.olo.movierank.MovieStudios;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.olo.movierank.R;
import com.example.olo.movierank.MovieRank.MovieRankWebViewClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLO on 2018/2/28.
 * expandableLayout裡面的RecyclerView的adapter
 * 處理要顯示全國的影城、網站、地點
 */

public class MoviesStudioData extends RecyclerView.Adapter<MoviesStudioData.ViewHolder> {
    private List<MovieStudioDataItem> mValues= new ArrayList<>();
    public String tag=" ";
    private Context context;
    private LayoutInflater inflater;

    private List<String> msrvDataNameList= new ArrayList<>();
    private  int x;

    public MoviesStudioData(Context context, List<MovieStudioDataItem> mValues) {
        this.context = context;
        this.mValues = mValues;
        inflater=LayoutInflater.from(context);
        int i;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = inflater.inflate(R.layout.movie_studio_list_item_data,parent);
        ViewHolder viewHolder=new ViewHolder(view);
        //this.context = parent.getContext();
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {
        String ItemName= mValues.get(position).getMSItemName();
        String ItemUrl= mValues.get(position).getMSItemUrl();
        String ItemAdr= mValues.get(position).getMSItemadr();
            holder.textView.setText(mValues.get(position).getMSItemName());
            holder.mAdfString= mValues.get(position).getMSItemadr();
            holder.mUrlString=mValues.get(position).getMSItemUrl();
//        Log.d(tag,ItemName);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//               Context context = v.getContext();
//               Intent intent = new Intent(context, MovieRankWebViewClient.class);
//               intent.putExtra(MovieRankWebViewClient.ThreeEXTRA_url, holder.mUrlString);
//               context.startActivity(intent);
            }
        });

        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(context, Tab3_Map.class);
//
//                intent.putExtra(Tab3_Map.Maplatlng, holder.mAdfString);
//                intent.putExtra(Tab3_Map.MovieName, holder.mNameString);
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size() ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mUrlString;
        public String mNameString;
        public String mAdfString;
        public TextView textView;
        public RelativeLayout buttonLayout;
        public final View mView;
        public ViewHolder(View v) {
            super(v);
            mView=v;
            textView = (TextView) v.findViewById(R.id.ms_tv);
            buttonLayout = (RelativeLayout) v.findViewById(R.id.map_btn);

        }

    }
}

