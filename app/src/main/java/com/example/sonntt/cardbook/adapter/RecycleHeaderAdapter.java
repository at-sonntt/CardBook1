package com.example.sonntt.cardbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sonntt.cardbook.model.DataHeaderRecycle;
import com.example.sonntt.cardbook.R;

import java.util.ArrayList;


/**
 * Created by MrSon on 24/10/2015.
 */


@SuppressWarnings("DefaultFileTemplate")
public class RecycleHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DataHeaderRecycle> mListSong;
    private Context mContext;



    public RecycleHeaderAdapter(ArrayList<DataHeaderRecycle> mListSong, Context mContext) {
        this.mListSong = mListSong;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycle_header,parent, false);
      // BusProvider.getInstance().register(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final DataHeaderRecycle dataSong = mListSong.get(position);
        final ViewHolder viewHolder = (ViewHolder) holder;
    }

    @Override
    public int getItemCount() {
        return mListSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
