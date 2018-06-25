package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity Bicycle extends Item and has a joined table DB stucture
 * PrimaryKeyJoinColumn(name="id") - primary key that has a foreing dependency.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Data
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = Bicycle.ALL_BICYCLE_QUERY,
                query = "select e from Bicycle e"),
        @NamedQuery(name = Bicycle.BICYCLE_QUERY,
                query = "select e from Bicycle e WHERE e.itemType.id = :id")
})
public class Bicycle extends Item implements Serializable {

    public static final String BICYCLE_QUERY = "Item.getBicycles";

    public static final String ALL_BICYCLE_QUERY = "Item.getAllBicycles";

    private String fork;

    private String brakes;

    private String frame;

    public Bicycle(ItemType itemType) {
        super(itemType);
    }

}