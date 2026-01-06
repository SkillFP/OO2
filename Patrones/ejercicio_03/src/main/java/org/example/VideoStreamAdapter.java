package org.example;

public class VideoStreamAdapter implements Media{
    private VideoStream videoStream;

    public VideoStreamAdapter(VideoStream videoStream){
        this.videoStream = videoStream;
    }

    @Override
    public void play() {
        System.out.println("----> Adaptando VideoStream...");
        this.videoStream.reproduce();
    }
}
