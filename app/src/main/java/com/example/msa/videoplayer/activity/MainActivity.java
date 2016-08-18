package com.example.msa.videoplayer.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.msa.videoplayer.adapter.VerticalRecyclerViewAdapter;
import com.example.msa.videoplayer.adapter.VideosAdapter;
import com.example.msa.videoplayer.utils.Config;
import com.example.msa.videoplayer.R;
import com.example.msa.videoplayer.utils.DialogUtils;
import com.example.msa.videoplayer.utils.EndlessRecyclerOnScrollListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    //    public static final int RECOVERY_REQUEST = 1;
//    YouTubePlayerView youTubePlayerView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private VerticalRecyclerViewAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewVideos);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        linearLayoutManager = new LinearLayoutManager(this);
        endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                getVideos((current_page * visibleThreshold), visibleThreshold);
            }
        };
        mRecyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
        adapter = new VerticalRecyclerViewAdapter(this, 10);
//        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                getVideos();
            }
        });
//        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
//        youTubePlayerView.initialize(Config.YOUTUBEAPIKEY, this);
    }
//        @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//        if (!b){
//            youTubePlayer.cueVideo("HWvzhfI4SuM");
//        }
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//        if (youTubeInitializationResult.isUserRecoverableError()){
//            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
//        } else {
//            String error = String.format("Error initializing YouTube player", youTubeInitializationResult.toString());
//            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RECOVERY_REQUEST){
//            getYouTubePlayerProvider().initialize(Config.YOUTUBEAPIKEY, this);
//        }
//    }

//    protected YouTubePlayer.Provider getYouTubePlayerProvider(){
//        return youTubePlayerView;
//    }

    public void getVideos(int... pagingParams) {
        try {
            if (pagingParams.length == 2) {
                endlessRecyclerOnScrollListener.decreasePagingCount();
            }
            mSwipeRefreshLayout.setRefreshing(true);
            if (pagingParams.length == 2) {
                mSwipeRefreshLayout.setRefreshing(false);
                adapter = new VerticalRecyclerViewAdapter(this, 10);
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setAdapter(adapter);
            } else {
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRefresh() {
        resetLoading();
        getVideos();
    }

    private void resetLoading() {
        if (adapter != null && mRecyclerView != null && linearLayoutManager != null){
            adapter.notifyDataSetChanged();
        }
        endlessRecyclerOnScrollListener.reset();
    }
}
