package com.cheise_proj.musicstructureapp.model;

public class Music {
    private int id;
    private String songName;
    private String artistName;

    public Music(int id, String songName, String artistName) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
