package com.wangby.www.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王炳炎 on 2017/4/24.
 */
public class HomeActivity extends BaseActivity{

    private TabLayout mTabTl;
    private ViewPager mContentVp;

    private List<String> tabString;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTabTl = (TabLayout) findViewById(R.id.tl_tab);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);

        initContent();
        initTab();
    }

    private void initTab(){
        mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(mTabTl, 10);
        mTabTl.setupWithViewPager(mContentVp);
    }

    private void initContent(){
        tabString = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabString.add("Tab " + i);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabString) {
            tabFragments.add(TabContentFragment.newInstance(s));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, SearchActivity.class));
//        switch (item.getItemId()) {
//            case R.id.tab_search:
//                tabString.add("Tab " + tabString.size());
//                tabFragments.add(TabContentFragment.newInstance(tabString.get(tabString.size()-1)));
//                contentAdapter.notifyDataSetChanged();
//                return true;
//
//            case R.id.tab_mode_fixed:
//                mTabTl.setTabMode(TabLayout.MODE_FIXED);
//                return true;
//
//            case R.id.tab_mode_scrollable:
//                mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }



    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabString.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabString.get(position);
        }
    }



}
