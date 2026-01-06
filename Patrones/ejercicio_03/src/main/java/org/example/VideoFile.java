package org.example;

public class VideoFile implements Media{

    public VideoFile(){}

    @Override
    public void play(){
        System.out.println("Reproduciendo VideoFile");
    }
}
