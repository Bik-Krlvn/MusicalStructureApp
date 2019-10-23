package com.cheise_proj.musicstructureapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cheise_proj.musicstructureapp.MusicItemSelector;
import com.cheise_proj.musicstructureapp.R;
import com.cheise_proj.musicstructureapp.model.Music;

class MusicViewHolder extends RecyclerView.ViewHolder {
    private TextView mSongName;
    private TextView mArtistName;

    MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        mSongName = itemView.findViewById(R.id.tv_song_name);
        mArtistName = itemView.findViewById(R.id.tv_artist_name);
    }

    void bind(final Music item, final MusicItemSelector<Music> callback) {
        mSongName.setText(item.getSongName());
        mArtistName.setText(item.getArtistName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(item);
            }
        });
    }
}