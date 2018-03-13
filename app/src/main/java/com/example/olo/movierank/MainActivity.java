package com.example.olo.movierank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.olo.movierank.ExpandableListTest.ExpandableListViewTest;
import com.example.olo.movierank.MovieRank.MovieRankFragment;
import com.example.olo.movierank.MovieStudios.MovieStudiosFragment;
import com.example.olo.movierank.TestExyLt.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private TextView mTextMessage;
    private ViewPager mViewPager ;
    private MenuItem menuItem;
    private String TAG ="MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setupViewPager(mViewPager);


    }
    private void setupViewPager(ViewPager viewPager) {
        Log.d(TAG, "setupViewPager");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(MovieRankFragment.newInstance("排名"));
        adapter.addFragment(ExpandableListViewTest.newInstance("影城"));
        adapter.addFragment(MovieStudiosFragment.newInstance("影城"));
        //adapter.addFragment(ExpandingviewTest.newInstance("設定"));

        viewPager.setAdapter(adapter); }




}
