package com.example.sonntt.cardbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sonntt.cardbook.model.DataMultiHeaderRecycle;
import com.example.sonntt.cardbook.R;

import java.util.ArrayList;

/**
 * A SectionedAdapter subclass that adapts Person objects to a list sectioned by the first letter
 * of each Person's last name.
 */
public class RecycleMultiHeaderAdapter extends SectionedAdapter<DataMultiHeaderRecycle> {
    private ArrayList<DataMultiHeaderRecycle> mListSong;
    private Context mContext;

    public RecycleMultiHeaderAdapter(ArrayList<DataMultiHeaderRecycle> mListSong, Context mContext) {
        this.mListSong = mListSong;
        this.mContext = mContext;
    }

    public RecycleMultiHeaderAdapter() {
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, DataMultiHeaderRecycle item, @ViewType int viewType) {
        ((PersonViewHolder) holder).nameView.setText(item.getDate());
        ((PersonViewHolder) holder).nameViewTwo.setText(item.getName());
        ((PersonViewHolder) holder).nameViewThree.setText(item.getDetail());
        ((PersonViewHolder) holder).year.setText(item.getYear());
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, @ViewType int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_multiheader, parent, false);
        return new PersonViewHolder(view);
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView nameView, nameViewTwo, nameViewThree, year;

        public PersonViewHolder(View itemView) {
            super(itemView);
            this.nameView = (TextView) itemView.findViewById(R.id.tvName);
            this.nameViewTwo = (TextView) itemView.findViewById(R.id.tvNameTwo);
            this.nameViewThree = (TextView) itemView.findViewById(R.id.tvNameThree);
            this.year = (TextView) itemView.findViewById(R.id.recycler_cell_person_name_label);
        }
    }
}
