package com.shs.entity.reference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ITEM_STATUS"))
public class ItemStatus {

    @Id
    @Column(name = "ID")
    private int itemStatusId;

    @Column(name = "STATUS")
    private String status;

    public ItemStatus(int itemStatusId, String status) {
        this.itemStatusId = itemStatusId;
        this.status = status;
    }

    public ItemStatus() {
    }

    public void setItemStatusId(int itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getItemStatusId() {
        return itemStatusId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return itemStatusId+ " "+status;
    }
}
