package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Clothes")
@PrimaryKeyJoinColumn(name="id")
@Data @NoArgsConstructor
public class Clothes extends Item {

    private String season;

    public Clothes(ItemType itemType) {
        super(itemType);
    }
}



