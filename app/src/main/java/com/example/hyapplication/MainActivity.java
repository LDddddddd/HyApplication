package com.example.hyapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String[] mTitle = new String[30];
    String[] mData = new String[30];
    TabLayout mTabyout;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }
    private void initData(){
        for (int i = 0;i<30;i++){
            mTitle[i]="第"+(i+1)+"个Tab";
            mData[i]="第"+(i+1)+"个Tab";
        }
    }
    private void initView() {
        mTabyout = (TabLayout) findViewById(R.id.tl_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle[position % mTitle.length];
            }

            @Override
            public Fragment getItem(int position) {
                TabFragment fragment = new TabFragment();
                fragment.setTitle(mData[position % mTitle.length]);
                return null;
            }

            @Override
            public int getCount() {
                return mTitle.length;
            }
        });
        mTabyout.setupWithViewPager(mViewPager);
        mTabyout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }

}
