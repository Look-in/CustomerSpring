package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data @NoArgsConstructor
public class Clothes extends Item {

    private String season;

    public Clothes(ItemType itemType) {
        super(itemType);
    }
}



