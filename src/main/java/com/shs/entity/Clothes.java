package com.shs.entity;

import javax.persistence.Entity;

@Entity
public class Clothes extends Item {

    private String season;

    public Clothes() {
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "season='" + season + '\'' + super.toString() +
                '}';
    }
}



