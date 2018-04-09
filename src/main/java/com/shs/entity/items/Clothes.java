package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity Clothes extends Item and has a joined table DB stucture
 * PrimaryKeyJoinColumn(name="id") - primary key that has a foreing dependency.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
public class Clothes extends Item {

    private String season;

    public Clothes(ItemType itemType) {
        super(itemType);
    }
}



