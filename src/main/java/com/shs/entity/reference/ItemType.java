package com.shs.entity.reference;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ITEM_TYPE"))
@Data @NoArgsConstructor
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

}

