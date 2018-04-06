package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Bicycle")
@PrimaryKeyJoinColumn(name="id")
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