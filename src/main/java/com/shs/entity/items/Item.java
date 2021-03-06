package com.shs.entity.items;

import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Default entity  - Item
 * Inheritance(strategy = InheritanceType.JOINED) - Item and extended entities are located
 * in the different tables
 * Data NoArgsConstructor - Lombok utility for automatic generation getters, setters, toString, Equals, Hashcode.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = Item.ALL_ITEM_QUERY,
                query = "select e from Item e"),
        @NamedQuery(name = Item.ITEM_QUERY,
                query = "select e from Item e WHERE e.itemType.itemTypeId = :id")
})
@Data
@NoArgsConstructor
public class Item {

    public static final String ITEM_QUERY = "Item.getItem";

    public static final String ALL_ITEM_QUERY = "Item.getAllItems";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer itemId;

    @Min(value = 0, message = "The value must be positive")
    private Integer price;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "item_status_id")
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }
}







