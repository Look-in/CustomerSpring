package com.shs.entity;

import javax.persistence.*;

@Entity
@Table(name=("ITEM_TYPE"))
/*@NamedQueries({
        @NamedQuery(name = ItemType.ALL_INVOICE_QUERY,
                query = "SELECT e FROM ITEM_TYPE e"),
        @NamedQuery(name = ItemType.INVOICE_QUERY,
                query = "SELECT e FROM ITEM_TYPE e WHERE e.id = :id")
})*/
public class ItemType {

    @Id
    @Column(name = "ID")
    private int itemTypeId;

    @Column(name = "ITEM_TYPE")
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

