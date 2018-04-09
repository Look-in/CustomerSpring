package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity Bicycle extends Item and has a joined table DB stucture
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 * @PrimaryKeyJoinColumn(name="id") - primary key that has a foreing dependency.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
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