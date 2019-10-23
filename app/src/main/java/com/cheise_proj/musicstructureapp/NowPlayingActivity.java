package com.cheise_proj.musicstructureapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cheise_proj.musicstructureapp.common.Constants;

import java.util.Objects;

public class NowPlayingActivity extends AppCompatActivity {
    private TextView mTitle;
    private TextView mArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        mTitle = findViewById(R.id.tv_song_title);
        mArtist = findViewById(R.id.tv_art_name);
        getIntentData();
    }

    // populate extras to text view
    private void getIntentData() {
        Intent getIntentExtra = getIntent();
        String[] data = getIntentExtra.getStringArrayExtra(Constants.KEY_MUSIC_EXTRA);
        if (data != null && data.length > 0) {
            mTitle.setText(data[0]);
            mArtist.setText(data[1]);
        }

    }

    public static Intent getInstance(Context context) {
        return new Intent(context, NowPlayingActivity.class);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
