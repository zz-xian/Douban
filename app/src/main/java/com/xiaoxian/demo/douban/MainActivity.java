package com.xiaoxian.demo.douban;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {

    private PagerSlidingTabStrip pagerTab;
    private ViewPager pager;
    public final int NUM_PAGES=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        pagerTab=(PagerSlidingTabStrip)findViewById(R.id.pager_tabs);
        pager=(ViewPager)findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        pagerTab.setViewPager(pager);
    }

    @Override
    public void onBackPressed() {
        if(pager.getCurrentItem()==0){
            super.onBackPressed();
        }else {
            pager.setCurrentItem(0);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter{
        private final String[] TITLES=getResources().getStringArray(R.array.pager_name);
        private PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle=new Bundle();
            Fragment pagerFragment;
            if(position==0){
                pagerFragment=new ListRefreshFragment();
            }else {
                pagerFragment=new PagerFragment();
            }
            bundle.putInt("page_num",position);
            pagerFragment.setArguments(bundle);
            return pagerFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
