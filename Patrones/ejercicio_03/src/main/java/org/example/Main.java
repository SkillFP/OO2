package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        mediaList.add(new Audio());
        mediaList.add(new VideoFile());
        mediaList.add(new VideoStreamAdapter(new VideoStream()));

        mediaList.forEach(Media::play);
    }
}