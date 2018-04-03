package com.shs.entity;

import com.shs.entity.reference.ItemType;

import javax.persistence.Entity;

@Entity
public class Clothes extends Item {

    private String season;

    public Clothes() {
    }

    public Clothes(ItemType itemType) {
        super(itemType);
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



