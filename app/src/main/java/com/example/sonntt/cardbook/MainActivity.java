package com.example.sonntt.cardbook;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sonntt.cardbook.CustomTab.TabBarCustom;
import com.example.sonntt.cardbook.fragment.FiveFragment_;
import com.example.sonntt.cardbook.fragment.FourFragment_;
import com.example.sonntt.cardbook.fragment.OneFragment_;
import com.example.sonntt.cardbook.fragment.ThreeFragment_;
import com.example.sonntt.cardbook.fragment.TwoFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById(R.id.tab)
    TabLayout mTab;

    @ViewById(R.id.imgOne)
    ImageView imgOne;


    @ViewById(R.id.imgTwo)
    ImageView imgTwo;


    @ViewById(R.id.imgThree)
    ImageView imgThree;


    @ViewById(R.id.imgFour)
    ImageView imgFour;


    @ViewById(R.id.imgFive)
    ImageView imgFive;

    @ViewById(R.id.viewpager)
    ViewPager mViewPager;

    @ViewById(R.id.tabBarBig)
    TabBarCustom mTabBar;

    ViewPagerAdapter mAdapter;

    private int mPosition = -1;


    @AfterViews
    void afterView() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(mViewPager);
        setupLayoutTab();
        setupTabIcons();
        mTabBar.setTabDefault();
        handleTabClick();

    }

    private void setupViewPager(ViewPager viewPager) {

        mAdapter.addFragment(new OneFragment_(), "");
        mAdapter.addFragment(new TwoFragment_(), "");
        mAdapter.addFragment(new ThreeFragment_(), "");
        mAdapter.addFragment(new FourFragment_(), "");
        mAdapter.addFragment(new FiveFragment_(), "");

        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(mAdapter);
    }

    private void setupLayoutTab() {

        mTab.setupWithViewPager(mViewPager);
        mTab.setSelectedTabIndicatorHeight(0);
        mTab.setSelectedTabIndicatorColor(Color.parseColor("#6A5ACD"));
    }

    private void handleTabClick() {
        mTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mViewPager.setCurrentItem(tab.getPosition());

                mPosition = tab.getPosition();

                if (mPosition == 0) {

                    mTabBar.setImageTabOne();

                } else if (mPosition == 1) {

                    mTabBar.setImageTabTwo();

                } else if (mPosition == 2) {

                    mTabBar.setImageTabThree();

                } else if (mPosition == 3) {

                    mTabBar.setImageTabFour();

                } else if (mPosition == 4) {

                    mTabBar.setImageTabFive();

                } else {
                    mTabBar.setTabDefault();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupTabIcons() {

        @SuppressLint("InflateParams") TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_current_tab, null);
        tabOne.setText("私は学校に");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_small, 0, 0);
        //noinspection ConstantConditions
        mTab.getTabAt(0).setCustomView(tabOne);

        @SuppressLint("InflateParams") TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_current_tab, null);
        tabTwo.setText("私は学校に");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_small, 0, 0);
        //noinspection ConstantConditions
        mTab.getTabAt(1).setCustomView(tabTwo);

        @SuppressLint("InflateParams") TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_current_tab, null);
        tabThree.setText("私は学校に");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_small, 0, 0);
        //noinspection ConstantConditions
        mTab.getTabAt(2).setCustomView(tabThree);

        @SuppressLint("InflateParams") TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_current_tab, null);
        tabFour.setText("私は学校に");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_small, 0, 0);
        //noinspection ConstantConditions
        mTab.getTabAt(3).setCustomView(tabFour);

        @SuppressLint("InflateParams") TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_current_tab, null);
        tabFive.setText("私は学校に");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_small, 0, 0);
        //noinspection ConstantConditions
        mTab.getTabAt(4).setCustomView(tabFive);

    }

}
