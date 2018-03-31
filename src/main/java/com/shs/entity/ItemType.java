package com.shs.entity;

public class ItemType {

    private int itemTypeId;

    private String type;

    public ItemType(int itemTypeId, String type) {
        this.itemTypeId = itemTypeId;
        this.type = type;
    }

    public ItemType() {
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return itemTypeId + " " + type;
    }
}

