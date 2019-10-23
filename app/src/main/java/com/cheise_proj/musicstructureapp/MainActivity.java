package com.cheise_proj.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMenus();
    }

    private void initMenus() {
        CardView btn_album = findViewById(R.id.card_album);
        CardView btn_nowPlaying = findViewById(R.id.card_now_playing);
        CardView btn_playlist = findViewById(R.id.card_playlist);
        CardView btn_songs = findViewById(R.id.card_songs);
        btn_songs.setOnClickListener(this);
        // set on click callback
        btn_playlist.setOnClickListener(this);
        btn_nowPlaying.setOnClickListener(this);
        btn_album.setOnClickListener(this);
    }

    // navigate to album activity
    public void navigateToAlbums() {
        startActivity(AlbumActivity.getInstance(getBaseContext()));
    }

    // navigate to now playing activity
    public void navigateToNowPlaying() {
        startActivity(NowPlayingActivity.getInstance(getBaseContext()));
    }

    // navigate to songs activity
    public void navigateToSongs() {
        startActivity(SongsActivity.getInstance(getBaseContext()));
    }

    // navigate to playlist activity
    public void navigateToPlaylist() {
        startActivity(PlaylistActivity.getInstance(getBaseContext()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_album:
                navigateToAlbums();
                break;
            case R.id.card_now_playing:
                navigateToNowPlaying();
                break;
            case R.id.card_playlist:
                navigateToPlaylist();
                break;
            case R.id.card_songs:
                navigateToSongs();
                break;
            default:
                break;
        }

    }
}
