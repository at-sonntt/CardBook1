package com.example.sonntt.cardbook.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sonntt.cardbook.model.DataMultiHeaderRecycle;
import com.example.sonntt.cardbook.R;
import com.example.sonntt.cardbook.adapter.RecycleMultiHeaderAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by sonntt on 12/29/15.
 */
@EFragment(R.layout.fragment_tab_one)
public class FragmentTabOne extends Fragment {

    ArrayList<DataMultiHeaderRecycle> mDatas;

    @ViewById(R.id.recycleViewMulti)
    RecyclerView mRecycle;

    @AfterViews
    void afterView(){

        setData();
        setUpRecycleView();
    }

    private void setUpRecycleView(){
        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        RecycleMultiHeaderAdapter personAdapter = new RecycleMultiHeaderAdapter();
        personAdapter.setItemList(mDatas);
        mRecycle.setAdapter(personAdapter);
    }

    private void setData(){

        mDatas = new ArrayList<>();

        DataMultiHeaderRecycle dataSong = new DataMultiHeaderRecycle("2014","人の名前を行い","人の名前を行い","人の名前を行い");
        DataMultiHeaderRecycle dataSong1 = new DataMultiHeaderRecycle("2015","人の名前を行い","人の名前を行い","人の名前を行い");
        DataMultiHeaderRecycle dataSong2 = new DataMultiHeaderRecycle("2014","人の名前を行い","人の名前を行い","人の名前を行い");
        DataMultiHeaderRecycle dataSong3 = new DataMultiHeaderRecycle("2014","人の名前を行い","人の名前を行い","人の名前を行い");

        mDatas.add(dataSong);
        mDatas.add(dataSong1);
        mDatas.add(dataSong3);
        mDatas.add(dataSong2);
    }
}
