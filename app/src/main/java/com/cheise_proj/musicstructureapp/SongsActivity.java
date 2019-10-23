package com.cheise_proj.musicstructureapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cheise_proj.musicstructureapp.adapter.SongAdapter;
import com.cheise_proj.musicstructureapp.common.Constants;
import com.cheise_proj.musicstructureapp.model.Music;

import java.util.ArrayList;
import java.util.Objects;

public class SongsActivity extends AppCompatActivity {
    private ArrayList<Music> musicArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        musicArrayList = new ArrayList<>();

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        SongAdapter adapter = new SongAdapter(new DiffUtil.ItemCallback<Music>() {
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
        adapter.setCallback(new MusicItemSelector<Music>() {
            @Override
            public void onItemClick(Music data) {
                startActivity(NowPlayingActivity
                        .getInstance(getBaseContext())
                        .putExtra(Constants.KEY_MUSIC_EXTRA, new String[]{data.getSongName(),
                                data.getArtistName()}));

            }
        });
        loadMusic();
        adapter.submitList(musicArrayList);
        recyclerView.setAdapter(adapter);

    }

    public static Intent getInstance(Context context) {
        return new Intent(context, SongsActivity.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void loadMusic() {
        String[] songs = {"song1.mp3",
                "song2.mp3",
                "song3.mp3",
                "song4.mp3",
                "song5.mp3",
                "song6.mp3",
                "song7.mp3",
                "song8.mp3",
                "song9.mp3",
                "song10.mp3"};
        String[] artist = {"artist1",
                "artist2",
                "artist3",
                "artist4",
                "artist5",
                "artist6",
                "artist7",
                "artist8",
                "artist9",
                "artist10"};

        for (int i = 0; i < songs.length; i++) {
            musicArrayList.add(new Music(i, songs[i], artist[i]));
        }
    }
}
