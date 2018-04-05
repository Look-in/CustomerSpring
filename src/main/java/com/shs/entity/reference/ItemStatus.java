package com.shs.entity.reference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ITEM_STATUS"))
public class ItemStatus {

    @Id
    @Column(name = "ID")
    @Getter @Setter
    private int itemStatusId;

    @Column(name = "STATUS")
    @Getter @Setter
    private String status;

    public ItemStatus(int itemStatusId, String status) {
        this.itemStatusId = itemStatusId;
        this.status = status;
    }

    public ItemStatus() {
    }

    @Override
    public String toString(){
        return itemStatusId+ " "+status;
    }
}
