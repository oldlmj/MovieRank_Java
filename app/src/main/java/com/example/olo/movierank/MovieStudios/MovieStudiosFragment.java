package com.example.olo.movierank.MovieStudios;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.example.olo.movierank.MyApplication.MyApplication;
import com.example.olo.movierank.R;
import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by OLO on 2018/2/27.
 */

public class MovieStudiosFragment  extends Fragment {
    private View mView;
    private Context context= MyApplication.getInstance();
    private List<MovieStudioDataItem> listItemModel = new ArrayList<>();
    private String TAG= "MovieStudiosFragment";
    private boolean isLoadData = false;
    private boolean isCreateView = false; //懶加載機制
    private RecyclerView recyclerviewtms;
    private MovieStudiosRecyclerViewAdapter msRecyclerViewAdapter;
    private MoviesStudioData msdata;


    public MovieStudiosFragment() {
    }

    public static MovieStudiosFragment newInstance(String info) {
        Bundle args = new Bundle();
        MovieStudiosFragment fragment = new MovieStudiosFragment();
        args.putString("MovieStudiosFragment", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isCreateView = true;
        Log.d(TAG, "onCreateView");
        return mView;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreateView) { //dk3ru0
            isLoadData = false;
            lazyLoad();
        }
    }

    private void lazyLoad() {
        if (!isLoadData) {
            final List<ItemModel> data = new ArrayList<ItemModel>();
            data.add(new ItemModel(0,
                    "基隆市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Keelung
                    ,MovieTheaterArea.Keelungurl
                    ,MovieTheaterArea.Keelungadress
            ));
            data.add(new ItemModel(1,
                    "台北市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Taipei
                    ,MovieTheaterArea.Taipeiurl
                    ,MovieTheaterArea.Taipeiadress
            ));
            data.add(new ItemModel(2,
                    "新北市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.NewTaipeiCity
                    ,MovieTheaterArea.NewTaipeiCityurl
                    ,MovieTheaterArea.NewTaipeiCityadress
            ));
            data.add(new ItemModel(3,
                    "桃園市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Taoyuan
                    ,MovieTheaterArea.Taoyuanurl
                    ,MovieTheaterArea.Taoyuanadress
            ));
            data.add(new ItemModel(4, //YYYYYYY
                    "新竹縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Hsinchu
                    ,MovieTheaterArea.Hsinchuurl
                    ,MovieTheaterArea.Hsinchuadress
            ));
            data.add(new ItemModel(5,
                    "苗栗縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Miaoli
                    ,MovieTheaterArea.Miaoliurl
                    ,MovieTheaterArea.Miaoliadress
            ));
            data.add(new ItemModel(6,
                    "臺中市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Taichung
                    ,MovieTheaterArea.Taichungurl
                    ,MovieTheaterArea.Taichungadress
            ));
            data.add(new ItemModel(7,
                    "彰化縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Changhua
                    ,MovieTheaterArea.Changhuaurl
                    ,MovieTheaterArea.Changhuaadress
            ));
            data.add(new ItemModel(8,
                    "南投縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Nantou
                    ,MovieTheaterArea.Nantouurl
                    ,MovieTheaterArea.Nantouadress
            ));
            data.add(new ItemModel(9,
                    "雲林縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Yunlin
                    ,MovieTheaterArea.Yunlinurl
                    ,MovieTheaterArea.Yunlinadress
            ));
            data.add(new ItemModel(10,
                    "嘉義縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Chiayi
                    ,MovieTheaterArea.Chiayiurl
                    ,MovieTheaterArea.Chiayiadress
            ));
            data.add(new ItemModel(11,
                    "台南市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Tainan
                    ,MovieTheaterArea.Tainanurl
                    ,MovieTheaterArea.Tainanadress
            ));
            data.add(new ItemModel(12,
                    "高雄市",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Kaohsiung
                    ,MovieTheaterArea.Kaohsiungurl
                    ,MovieTheaterArea.Kaohsiungadress
            ));
            data.add(new ItemModel(13,
                    "屏東縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Pingtung
                    ,MovieTheaterArea.Pingtungurl
                    ,MovieTheaterArea.Pingtungadress
            ));
            data.add(new ItemModel(14,
                    "臺東縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Taitung
                    ,MovieTheaterArea.Taitungurl
                    ,MovieTheaterArea.Taitungadress
            ));
            data.add(new ItemModel(15,
                    "花蓮縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.ACCELERATE_DECELERATE_INTERPOLATOR)
                    ,MovieTheaterArea.Hualien
                    ,MovieTheaterArea.Hualienurl
                    ,MovieTheaterArea.Hualienadress
            ));
            data.add(new ItemModel(16,
                    "宜蘭縣",
                    R.color.colorDarkBlue,
                    R.color.colorLightBlue,
                    Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)
                    ,MovieTheaterArea.Yilan
                    ,MovieTheaterArea.Yilanurl
                    ,MovieTheaterArea.Yilanadress
            ));

            msRecyclerViewAdapter =new MovieStudiosRecyclerViewAdapter(context,data);
            recyclerviewtms.setAdapter(msRecyclerViewAdapter);

//            int x;
//            for(x=0; x<data.size();x++){
//                ItemModel itemModel= data.get(x);
//                int y =itemModel.movieStudioName.length;
//                String[] name=itemModel.movieStudioName;
//                String[] url=itemModel.movieStudioUrl;
//                String[] adr=itemModel.movieStudioAdr;
//                MovieStudioDataItem msDataItem =new MovieStudioDataItem();
//                for (int i=0 ; i<y ; i++){
//                    msDataItem.setMSItemName(name[i]);
//                    msDataItem.setMSItemUrl(url[i]);
//                    msDataItem.setMSItemadr(adr[i]);
//                    String s=msDataItem.setMSItemName(name[i]);
//                    listItemModel.add(msDataItem);
//                    Log.d(TAG,);
//                }
//                msdata=new MoviesStudioData(context, listItemModel);
//            }

            isLoadData = true;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_moviestudios, null, false);
        recyclerviewtms = (RecyclerView) mView.findViewById(R.id.recyclerView_ms);
        recyclerviewtms.setHasFixedSize(true);
        recyclerviewtms.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d(TAG, "onCreate");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("FRAG", "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }
}
