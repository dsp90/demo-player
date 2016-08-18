package com.example.msa.videoplayer.adapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msa.videoplayer.R;
import com.example.msa.videoplayer.adapter.items.VideoViewHolder;

/**
 * Created by msa on 15/08/2016.
 */
public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity mContext;
    private int items;
    private LayoutInflater mInflater;

    public VerticalRecyclerViewAdapter(Activity mContext, int items) {
        this.mContext = mContext;
        this.items = items;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view =  mInflater.inflate(R.layout.layout_horizontal_recycler_view, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return items;
    }
}
