package com.example.msa.videoplayer.adapter.items;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.msa.videoplayer.R;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by msa on 09/08/2016.
 */
public class VideoHorizontalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public YouTubePlayerView mPlayer;

    public VideoHorizontalViewHolder(View itemView) {
        super(itemView);
        View view = itemView;
        try {
            mPlayer = (YouTubePlayerView) view.findViewById(R.id.youtubePlayerView);
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        //// TODO: 09/08/2016
    }
}
