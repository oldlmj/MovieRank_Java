package com.example.olo.movierank.TestExyLt;

import android.animation.TimeInterpolator;

/**
 * Created by OLO on 2018/2/28.
 */

public class TestItemModel {
    public final String description;
    public final int colorId1;
    public final int colorId2;
    public final TimeInterpolator interpolator;

    public TestItemModel(String description, int colorId1, int colorId2, TimeInterpolator interpolator) {
        this.description = description;
        this.colorId1 = colorId1;
        this.colorId2 = colorId2;
        this.interpolator = interpolator;
    }
}
