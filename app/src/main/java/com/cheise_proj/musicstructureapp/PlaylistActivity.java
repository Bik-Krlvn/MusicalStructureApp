package com.cheise_proj.musicstructureapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cheise_proj.musicstructureapp.adapter.PlaylistAdapter;
import com.cheise_proj.musicstructureapp.common.Constants;
import com.cheise_proj.musicstructureapp.model.Music;

import java.util.ArrayList;
import java.util.Objects;

public class PlaylistActivity extends AppCompatActivity {
    private ArrayList<Music> musicArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        musicArrayList = new ArrayList<>();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        PlaylistAdapter adapter = new PlaylistAdapter(new DiffUtil.ItemCallback<Music>() {
            @Override
            public boolean areItemsTheSame(@NonNull Music oldItem, @NonNull Music newItem) {
                return oldItem.getSongName().equals(newItem.getSongName()) &&
                        oldItem.getArtistName().equals(newItem.getArtistName());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Music oldItem, @NonNull Music newItem) {
                return oldItem.getSongName().equals(newItem.getSongName()) &&
                        oldItem.getArtistName().equals(newItem.getArtistName());
            }
        });

        // set item click listener callback
        adapter.setCallback(new MusicItemSelector<Music>() {
            @Override
            public void onItemClick(Music data) {
                startActivity(NowPlayingActivity
                        .getInstance(getBaseContext())
                        .putExtra(Constants.KEY_MUSIC_EXTRA, new String[]{data.getSongName(),
                                data.getArtistName()}));

            }
        });
        // populate data to list
        loadMusic();
        adapter.submitList(musicArrayList);
        recyclerView.setAdapter(adapter);

    }

    public static Intent getInstance(Context context) {
        return new Intent(context, PlaylistActivity.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void loadMusic() {
        String[] songs = {
                "playlist-1",
                "playlist-2",
                "playlist-3",
                "playlist-4",
                "playlist-5",
                "playlist-6",
                "playlist-7",
                "playlist-8",
                "playlist-9",
                "playlist-10"};
        String[] artist = {
                "10 tracks",
                "3 tracks",
                "20 tracks",
                "5 tracks",
                "13 tracks",
                "6 tracks",
                "1 track",
                "9 tracks",
                "11 tracks",
                "3 tracks"};

        for (int i = 0; i < songs.length; i++) {
            musicArrayList.add(new Music(i, songs[i], artist[i]));
        }
    }

}
