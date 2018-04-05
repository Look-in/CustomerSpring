package com.shs.entity;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Bicycle extends Item {

    private String fork;

    private String brakes;

    private String frame;

    public Bicycle(ItemType itemType) {
        super(itemType);
    }

}