package com.example.olo.movierank.MovieStudios;

import android.animation.TimeInterpolator;

/**
 * Created by OLO on 2018/2/28.
 */

public class ItemModel {
    public final int elpon;
    public final String description;
    public final int colorId1;
    public final int colorId2;
    public final TimeInterpolator interpolator;
    public final String[] movieStudioName;
    public final String[] movieStudioUrl;
    public final String[] movieStudioAdr;


    private String movie;

    private String url;

    public void setMovie(String movie){
        this.movie = movie;
    }

    public String getMovie(){
        return this.movie;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public ItemModel(int elpon , String description, int colorId1, int colorId2, TimeInterpolator interpolator, String[] movieStudioName,String[] movieStudioUrl,String[] movieStudioAdr) {
        this.description = description;
        this.colorId1 = colorId1;
        this.colorId2 = colorId2;
        this.interpolator = interpolator;
        this.elpon=elpon;
        this.movieStudioName=movieStudioName;
        this.movieStudioUrl=movieStudioUrl;
        this.movieStudioAdr= movieStudioAdr;
    }
}
