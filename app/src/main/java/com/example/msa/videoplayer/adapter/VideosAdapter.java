package com.example.msa.videoplayer.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.msa.videoplayer.R;
import com.example.msa.videoplayer.adapter.items.VideoHorizontalViewHolder;
import com.example.msa.videoplayer.utils.Config;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

/**
 * Created by msa on 07/08/2016.
 */
public class VideosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity context;
    private LayoutInflater inflater;
    private int RECOVERY_REQUEST = 1;

    public VideosAdapter(Activity context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_video_layout, parent, false);
        return new VideoHorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ((VideoHorizontalViewHolder) holder).mPlayer.initialize(Config.YOUTUBEAPIKEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b)
                youTubePlayer.loadVideo("HWvzhfI4SuM");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError()){
                    youTubeInitializationResult.getErrorDialog(context, RECOVERY_REQUEST).show();
                } else {
                    String error = String.format("Error", youTubeInitializationResult.toString());
                    Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

//    public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        public YouTubeThumbnailView youTubeThumbnailView;
//        public VideoPlayerView videoPlayerView;
//
//        public VideoViewHolder(View itemView) {
//            super(itemView);
//            View view = itemView;
//            youTubeThumbnailView = (YouTubeThumbnailView) view.findViewById(R.id.youtubethumbNail);
//            youTubeThumbnailView.setOnClickListener(this);
//            videoPlayerView = (VideoPlayerView) view.findViewById(R.id.vdoView);
//        }
//
//        @Override
//        public void onClick(View v) {
//            Intent intent = YouTubeStandalonePlayer.createVideoIntent(context, Config.YOUTUBEAPIKEY, "HWvzhfI4SuM");
//            context.startActivity(intent);
//        }
//    }
}
