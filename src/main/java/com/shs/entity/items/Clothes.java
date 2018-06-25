package com.shs.entity.items;

import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

/**
 * Entity Clothes extends Item and has a joined table DB stucture
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
        @NamedQuery(name = Clothes.ALL_CLOTHES_QUERY,
                query = "select e from Clothes e"),
        @NamedQuery(name = Clothes.CLOTHES_QUERY,
                query = "select e from Clothes e WHERE e.itemType.id = :id")
})
public class Clothes extends Item implements Serializable {

    public static final String CLOTHES_QUERY = "Item.getClothes";

    public static final String ALL_CLOTHES_QUERY = "Item.getAllClothes";

    private String season;

    public Clothes(ItemType itemType) {
        super(itemType);
    }
}



