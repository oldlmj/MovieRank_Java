package com.example.olo.movierank.MovieStudios;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.olo.movierank.R;
import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by OLO on 2018/2/28.
 * expandableLayout的建立
 */

public class MovieStudiosRecyclerViewAdapter extends RecyclerView.Adapter<MovieStudiosRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<ItemModel> data= new  ArrayList<>();
    private String[] url;
    private String[] name;
    private String[] adr;
    private String MSName,MSUtl,MSAdr;
   // private MoviesStudioData msDatarv;
    private String TAG="MovieStudiosRecyclerViewAdapter";
    private List<MovieStudioDataItem> msDatalist = new  ArrayList<MovieStudioDataItem>();
    //private  MovieStudioDataItem msDataItem;
    int elrv,y;

    private SparseBooleanArray expandState = new SparseBooleanArray();

    public MovieStudiosRecyclerViewAdapter( final Context context, List<ItemModel> data) {
        this.context = context;
        this.data=data;

        Log.d(TAG ,"MovieStudiosRecyclerViewAdapter");
        for (int i = 0; i < data.size(); i++) {
            expandState.append(i, false);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        Log.d(TAG ,"onCreateViewHolder");
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_studios_list_item, parent, false));
    }
   //數據與介面綁定
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemModel item = data.get(position);
        elrv=item.elpon;
        name=item.movieStudioName;
        url=item.movieStudioUrl;
        adr=item.movieStudioAdr;
        Log.d(TAG, elrv+"+"+name);
        final Resources resource = context.getResources();
        holder.setIsRecyclable(false);

        msDatalist=writeMsData();
        MoviesStudioData msDatarv=new MoviesStudioData(context,msDatalist);
        holder.el_recyclerView.setLayoutManager(new WrappingLinearLayoutManager(context));
        holder.el_recyclerView.setNestedScrollingEnabled(false);
        holder.el_recyclerView.setHasFixedSize(true);
        holder.el_recyclerView.setAdapter(msDatarv);

        holder.textView.setText(item.description);
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, item.colorId1)); //???????
        //holder.expandableLayout.setInRecyclerView(true);
        holder.expandableLayout.setBackgroundColor(ContextCompat.getColor(context, item.colorId2));
        holder.expandableLayout.setInterpolator(item.interpolator);
        holder.expandableLayout.setExpanded(expandState.get(position));
        holder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                expandState.put(position, true);
               // holder.el_recyclerView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onPreClose() {
                createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                expandState.put(position, false);
                //holder.el_recyclerView.setVisibility(View.GONE);

            }
        });
        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout);
            }
        });
        int n =0;
        Log.d(TAG ,"onBindViewHolder -" +n);
        n++;


    }

    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }

    public List<MovieStudioDataItem> writeMsData(){
        MovieStudioDataItem msDataItem=new MovieStudioDataItem();
        for (int n=0; n <name.length; n++)
        {
            String sName=name[n];
            String sUrl=url[n];
            String sAdr=adr[n];
            msDataItem.setMSItemadr(sName);
            msDataItem.setMSItemUrl(sUrl);
            msDataItem.setMSItemadr(sAdr);
            msDatalist.add(msDataItem);
            Log.d(TAG, n+"+"+sName);
        }
        return msDatalist;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

///////////////////////////////////////////////////////////////////////////////////////

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  Context context;
        private  String TAG="textView";
        public TextView textView;
        public RelativeLayout buttonLayout;
        public RecyclerView el_recyclerView;
        public ExpandableRelativeLayout expandableLayout;

        public ViewHolder(View v) {
            super(v);
            context=v.getContext();
            textView = (TextView) v.findViewById(R.id.textView);
            buttonLayout = (RelativeLayout) v.findViewById(R.id.button);
            expandableLayout = (ExpandableRelativeLayout) v.findViewById(R.id.expandableLayout);
            el_recyclerView=(RecyclerView) v.findViewById(R.id.recyclerView_mv_data);
            //el_recyclerView.addItemDecoration(new DividerItemDecoration(context));

            Log.d(TAG ,"ViewHolder");
        }
    }

    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }
}
