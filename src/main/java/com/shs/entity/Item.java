package com.shs.entity;

import com.shs.entity.reference.ItemStatus;
import com.shs.utils.SetException;
import com.shs.entity.reference.ItemType;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = Item.ALL_ITEM_QUERY,
                query = "select e from Item e"),
        @NamedQuery(name = Item.ITEM_QUERY,
                query = "select e from Item e WHERE e.itemType.itemTypeId = :id")
})
public class Item {

    public static final String ITEM_QUERY = "Item.getItem";

    public static final String ALL_ITEM_QUERY = "Item.getAllItems";

    @Id
    @Column(name = "ID")
    private int itemId;

    @Column
    private Integer price;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="item_status_id")
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name="item_type_id")
    private ItemType itemType;

    public Item(Integer itemId, Integer price, String name, String description, ItemStatus itemStatus, ItemType itemType) {
        this.itemId = itemId;
        this.price = price;
        this.name = name;
        this.description = description;
        this.itemStatus = itemStatus;
        this.itemType = itemType;
    }

    public Item() {
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    // @Test
    public void setPrice(int price) {
        if (price <= 0) throw new SetException("Error. Price not specified");
        else this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item [Id =" + itemId + ", price=" +
                String.format("%.2f", price) + ", name=" + name + " description= " +
                description + " status=" + itemStatus.toString() + " type=" + itemType.toString();
    }
}







