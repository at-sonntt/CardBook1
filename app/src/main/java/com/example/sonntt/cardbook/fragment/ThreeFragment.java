package com.example.sonntt.cardbook.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sonntt.cardbook.model.DataFruits;
import com.example.sonntt.cardbook.R;
import com.example.sonntt.cardbook.adapter.ExpandableListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by sonntt on 12/23/15.
 */
@EFragment(R.layout.three_fragment)
public class ThreeFragment extends Fragment {

    ArrayList<DataFruits> mFruits;
    ArrayList<ExpandableListAdapter.Item> mDatas;

    @ViewById(R.id.recycleMain)
    RecyclerView mRecycle;

    @AfterViews
    void afterView(){

        mRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        setData();
    }

    private void setData() {
        mDatas = new ArrayList<>();

        ExpandableListAdapter.Item mPlaces;
        ExpandableListAdapter.Item mPlaces1;
        ExpandableListAdapter.Item mPlaces2;
        ExpandableListAdapter.Item mPlaces3;
        DataFruits fruits = new DataFruits();

        fruits.setNameFruit("Orange");
        fruits.setInfo("Orange, Orange, Orange, Orange, Orange");

        DataFruits fruits1 = new DataFruits();

        fruits1.setNameFruit("Orange");
        fruits1.setInfo("Orange, Orange, Orange, Orange, Orange");

        DataFruits fruits2 = new DataFruits();

        fruits2.setNameFruit("Orange");
        fruits2.setInfo("Orange, Orange, Orange, Orange, Orange");

        DataFruits fruits3 = new DataFruits();

        fruits3.setNameFruit("Orange");
        fruits3.setInfo("Orange, Orange, Orange, Orange, Orange");


        mPlaces = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, fruits.getNameFruit());
        mPlaces.invisibleChildren = new ArrayList<>();
        mPlaces.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, fruits.getInfo()));

        mPlaces1 = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, fruits1.getNameFruit());
        mPlaces1.invisibleChildren = new ArrayList<>();
        mPlaces1.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, fruits1.getInfo()));

        mPlaces2 = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, fruits2.getNameFruit());
        mPlaces2.invisibleChildren = new ArrayList<>();
        mPlaces2.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, fruits2.getInfo()));

        mPlaces3 = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, fruits3.getNameFruit());
        mPlaces3.invisibleChildren = new ArrayList<>();
        mPlaces3.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, fruits3.getInfo()));

        mDatas.add(mPlaces);
        mDatas.add(mPlaces1);
        mDatas.add(mPlaces2);
        mDatas.add(mPlaces3);

        mRecycle.setAdapter(new ExpandableListAdapter(mDatas));


    }

}
