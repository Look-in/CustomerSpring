package com.shs.entity;


public class Bicycle extends Item {
    private String fork;
    private String brakes;
    private String frame;

    public Bicycle() {
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "fork='" + fork + '\'' +
                ", brakes='" + brakes + '\'' +
                ", frame='" + frame + '\'' +
                '}' + super.toString();
    }
}




