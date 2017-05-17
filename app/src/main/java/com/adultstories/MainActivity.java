package com.adultstories;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rg.realstate.adapter.MyPageAdapter;
import com.rg.realstate.fragments.AFragment;
import com.rg.realstate.fragments.BFragment;
import com.rg.realstate.fragments.CFragment;
import com.rg.realstate.fragments.DFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    static Context context;
    List<Fragment> fragments;
    ImageView ivAdd;
    AFragment aFragment = new AFragment();
    BFragment bFragment = new BFragment();
    CFragment cFragment = new CFragment();
    DFragment dFragment = new DFragment();
    ViewPager viewPager;
    MyPageAdapter pagerAdapter;

    View v,vi,v1,v2;
    TextView textViewA, textViewB,textVieww_search,textVieww_profile;
    ImageView iv_search,iv_profile, iv_A, iv_B;
    TabLayout tabLayout;
    int tabPosition;
   // Toolbar mToolbar;
    private String TAG="MainActivity";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =MainActivity.this;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ivAdd =(ImageView)findViewById(R.id.iv_add) ;

        init();
        initViewPagerAndTabs();
    }

    @Override
    protected int getToolbar() {
        return R.id.toolbar;
    }

    @Override
    protected int getActivityID() {
        return 0;
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.app_name;
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Activity getInstance() {
        return MainActivity.this;
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    private void init() {
        fragments = new ArrayList<>();
        fragments.add(aFragment);
        fragments.add(bFragment);
        fragments.add(cFragment);
        fragments.add(dFragment);
        pagerAdapter = new MyPageAdapter(this.getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void initViewPagerAndTabs() {

        v = View.inflate(context, R.layout.tab_custom_view, null);
        textViewB = (TextView) v.findViewById(R.id.tv_title);
        iv_A =(ImageView)v.findViewById(R.id.iv_title_image);
        iv_A.setImageResource(R.mipmap.ic_launcher_round);
        iv_A.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary));
        textViewB.setText(MainActivity.this.getString(R.string.app_name));
        textViewB.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
        tabLayout.getTabAt(0).setCustomView(v);

        vi = View.inflate(context, R.layout.tab_custom_view, null);
        textViewA = (TextView) vi.findViewById(R.id.tv_title);
        textViewA.setText(MainActivity.this.getString(R.string.app_name));
        iv_B =(ImageView)vi.findViewById(R.id.iv_title_image);
        iv_B.setImageResource(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(1).setCustomView(vi);

        v1 = View.inflate(context, R.layout.tab_custom_view, null);
        textVieww_search = (TextView) v1.findViewById(R.id.tv_title);
        textVieww_search.setText(MainActivity.this.getString(R.string.app_name));
        iv_search=(ImageView)v1.findViewById(R.id.iv_title_image);
        iv_search.setImageResource(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(2).setCustomView(v1);

        v2 = View.inflate(context, R.layout.tab_custom_view, null);
        textVieww_profile = (TextView) v2.findViewById(R.id.tv_title);
        textVieww_profile.setText(MainActivity.this.getString(R.string.app_name));
        iv_profile=(ImageView)v2.findViewById(R.id.iv_title_image);
        iv_profile.setImageResource(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(3).setCustomView(v2);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPosition = tab.getPosition();

                if (tab.getPosition() == 0) {
                    textViewB.setTextColor(ContextCompat.getColor(context,R.color.white));
                    textViewA.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textVieww_search.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textVieww_profile.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));

                    iv_A.setColorFilter(ContextCompat.getColor(context, R.color.white));
                    iv_B.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_search.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_profile.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    ivAdd.setVisibility(View.VISIBLE);
                    viewPager.setCurrentItem(0);
                } else if (tab.getPosition() == 1) {
                    textViewA.setTextColor(ContextCompat.getColor(context,R.color.white));
                    textViewB.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textVieww_search.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textVieww_profile.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));

                    iv_B.setColorFilter(ContextCompat.getColor(context, R.color.white));
                    iv_search.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_A.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_profile.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));

                    ivAdd.setVisibility(View.VISIBLE);
                    viewPager.setCurrentItem(1);
                }
                else if (tab.getPosition() == 2) {
                    textVieww_search.setTextColor(ContextCompat.getColor(context,R.color.white));
                    textViewA.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textViewB.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textVieww_profile.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));

                    iv_search.setColorFilter(ContextCompat.getColor(context, R.color.white));
                    iv_A.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_B.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_profile.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));

                    ivAdd.setVisibility(View.GONE);
                    viewPager.setCurrentItem(2);
                } else if (tab.getPosition()==3){
                    textVieww_profile.setTextColor(ContextCompat.getColor(context,R.color.white));
                    textVieww_search.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textViewA.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
                    textViewB.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));

                    iv_profile.setColorFilter(ContextCompat.getColor(context, R.color.white));
                    iv_search.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_A.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    iv_B.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark));

                    ivAdd.setVisibility(View.GONE);
                    viewPager.setCurrentItem(3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new PageListener());
    }
    private class PageListener extends ViewPager.SimpleOnPageChangeListener {
        public void onPageSelected(int position) {
            Log.i("", "page selected " + position);

        }
    }

}
