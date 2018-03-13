package com.example.olo.movierank.MovieRank;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.olo.movierank.MyApplication.MyApplication;
import com.example.olo.movierank.R;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLO on 2018/2/26.
 */

public class MovieRankFragment extends Fragment {

    private RecyclerView recyclerviewone;
    private LinearLayoutManager linearLayoutManager;
    private View mView;
    private String link;
    private Context context = MyApplication.getInstance();
    private List<MovieJsoup> aslist = new ArrayList<MovieJsoup>();
    private MovieRecyclerViewAdapter recyclerViewAdapterone;
    private String TAG = "MovieRankFragment";
    //Fragment的view加載完成時標記
    private boolean isViewCreated;
    //Fragment對用戶可見的標記
    private boolean isUIVisible;

    public static MovieRankFragment newInstance(String info) {
        Bundle args = new Bundle();
        MovieRankFragment fragment = new MovieRankFragment();
        args.putString("MovieRankFragment", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Fragment剛被建立時執行此方法
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_movierank, null, false);
        recyclerviewone = (RecyclerView) mView.findViewById(R.id.fragment_movierank_rw);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerviewone.setHasFixedSize(true);
        recyclerviewone.setLayoutManager(linearLayoutManager);

        Toast.makeText(getActivity(), "載入中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "MovieRankFragment - onCreateView");
        isViewCreated = true;
        lazyLoad();
        return mView;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }
    private  void lazyLoad(){
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            loadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;

            //printLog(mTextviewContent+"可见,加载数据");
        }
    }

    protected void loadData() {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        // 在這個方法中取得並定義Fragment的介面元件
        super.onActivityCreated(savedInstanceState);

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "runnable start");
            aslist = getJSOUP();
            recyclerViewAdapterone = new MovieRecyclerViewAdapter(context, aslist);
            handler.sendEmptyMessage(1);
        }
    };

    Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                recyclerviewone.setAdapter(recyclerViewAdapterone);
            }
        }
    };

    public List<MovieJsoup> getJSOUP() {
        String name;
        int number = 2;
        Connection.Response response = null;

        try {
            while (response == null || response.statusCode() != 200) {
                response = Jsoup.connect("https://movies.yahoo.com.tw/chart.html").timeout(3000).execute();
                Thread.sleep(1000);
            }
            int urli = 1;
            Document doc = response.parse();
            Elements movieF = doc.select("dd>h1"); //要解析的tag元素為dd
            Elements movieS = doc.select("div[class=td]>a");  //要解析的tag元素為td到下層的a
            for (int i = 0; i < 19; i++) {
                MovieJsoup titleItem = new MovieJsoup();
                if (i == 0) {
                    Elements eName0 = movieF.select("h1");
                    Elements eLink0 = movieS.select("a");
                    name = 1 + ". " + eName0.text();
                    link = eLink0.attr("href");
                    titleItem.setTitle(name);
                    titleItem.setLink(link);
                    aslist.add(titleItem);
                    Log.d(TAG, name);
                }
                Elements elink = movieS.select("a");
                Elements enameI = movieS.select("div.rank_txt");
                name = number + ". " + enameI.get(i).text(); //取得標籤屬性中的值的方法
                link = elink.get(urli).attr("href");
                titleItem = new MovieJsoup();
                titleItem.setTitle(name);
                titleItem.setLink(link);
                aslist.add(titleItem);
                Log.d(TAG, name);
                Log.d(TAG, link);
                number++;
                urli++;
            }

            Log.d(TAG, "getJSOUP end");

            return aslist;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return null;
    }

    @Override
    public void onPause() {
        // 當Fragment要從螢幕消失時執行此方法
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
        isUIVisible = false;
    }
}
