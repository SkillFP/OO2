package org.example;

public class Audio implements Media{

    public Audio(){}

    @Override
    public void play() {
        System.out.println("Reproduciendo Audio");
    }
}
