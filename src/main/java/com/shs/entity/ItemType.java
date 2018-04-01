package com.shs.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ITEM_TYPE"))
public class ItemType {

    /**  */
   // public static final String ITEM_TYPE_QUERY = "ItemType.getInvoice";

    /** Запрос получения всех накладных. */
   // public static final String ALL_ITEM_TYPE_QUERY = "ItemType.getAllInvoices";

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

