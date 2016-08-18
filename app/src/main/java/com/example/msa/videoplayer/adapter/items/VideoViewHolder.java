package com.example.msa.videoplayer.adapter.items;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.msa.videoplayer.R;
import com.example.msa.videoplayer.adapter.VideosAdapter;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by msa on 09/08/2016.
 */
public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public RecyclerView recyclerView;

    public VideoViewHolder(View itemView) {
        super(itemView);
        View view = itemView;
        try {
            recyclerView = (RecyclerView) view.findViewById(R.id.horizontalRecyclerView);
            VideosAdapter adapter = new VideosAdapter((Activity) itemView.getContext());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        //// TODO: 09/08/2016
    }
}
