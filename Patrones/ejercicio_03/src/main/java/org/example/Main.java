package org.example;

public class Main {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();

        mediaPlayer.addMedia(new Audio());
        mediaPlayer.addMedia(new VideoFile());
        mediaPlayer.addMedia(new VideoStreamAdapter(new VideoStream()));

        mediaPlayer.play();
    }
}