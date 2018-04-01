package com.shs.entity;


import com.shs.utils.SetException;
import com.shs.entity.ItemStatus;
import com.shs.entity.ItemType;
import sun.misc.BASE64Encoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @Column(name = "ID")
    private int itemId;

    private Integer price;

    private String name;

    private String description;

    private byte[] image;

    private ItemStatus itemStatus;

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

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    // encoding the byte image string
    //удалить после отладки, если будет реализован иной метод
    public String getBase64imageFile() {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder imageString = new StringBuilder();
        imageString.append("data:image/png;base64,");
        imageString.append(base64Encoder.encode(image));
        return imageString.toString();
    }


    @Override
    public String toString() {
        return "Item [Id =" + itemId + ", price=" +
                String.format("%.2f", price) + ", name=" + name + " description= " +
                description + " status=" + itemStatus.toString() + " type=" + itemType.toString();
    }
}







