package com.example.olo.movierank.ExpandableListTest;

/**
 * Created by OLO on 2018/3/7.
 *   分组展開監視器
 */

public  interface OnGroupExpandedListener {
    /**
     * 分组展开
     *
     * @param groupPosition 分组的位置
     */
    void onGroupExpanded(int groupPosition);
}
