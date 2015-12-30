package com.example.sonntt.cardbook.fragment;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.sonntt.cardbook.R;
import com.example.sonntt.cardbook.adapter.RecentsAdapter;
import com.example.sonntt.cardbook.until.RecentsList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by sonntt on 12/23/15.
 */
@EFragment(R.layout.four_fragment)
public class FourFragment extends Fragment {

    private RecentsAdapter mAdapter;



    @AfterViews
    void afterView(){

        setupData();
        RecentsList recents = (RecentsList) getView().findViewById(R.id.recents);
        recents.setAdapter(mAdapter);
   }

    private void setupData(){
        mAdapter = new RecentsAdapter() {
            @Override
            public String getTitle(int position) {
                return null;
            }

            @Override
            public View getView(int position) {
                return null;
            }

            @Override
            public Drawable getIcon(int position) {
                return null;
            }

            @Override
            public int getHeaderColor(int position) {
                return 0;
            }

            @Override
            public int getCount() {
                return 30;
            }
        };
    }
}
