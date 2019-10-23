package com.cheise_proj.musicstructureapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.cheise_proj.musicstructureapp.MusicItemSelector;
import com.cheise_proj.musicstructureapp.R;
import com.cheise_proj.musicstructureapp.model.Music;

public class PlaylistAdapter extends ListAdapter<Music, MusicViewHolder> {
    private MusicItemSelector<Music> callback;
    public PlaylistAdapter(@NonNull DiffUtil.ItemCallback<Music> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_playlist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        holder.bind(getItem(position),callback);

    }

    public void setCallback(MusicItemSelector<Music> callback) {
        this.callback = callback;
    }
}
