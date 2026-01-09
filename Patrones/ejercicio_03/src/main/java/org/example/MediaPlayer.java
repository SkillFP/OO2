package org.example;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer{
    private List<Media> media;

    public MediaPlayer() {
        this.media = new ArrayList<>();
    }

    public void addMedia(Media media) {
        this.media.add(media);
    }

    public void play() {
        this.media.forEach(Media::play);
    }
}