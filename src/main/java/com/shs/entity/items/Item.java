package com.shs.entity.items;

import com.shs.entity.reference.ItemStatus;
import com.shs.entity.reference.ItemType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = Item.ALL_ITEM_QUERY,
                query = "select e from Item e"),
        @NamedQuery(name = Item.ITEM_QUERY,
                query = "select e from Item e WHERE e.itemType.itemTypeId = :id")
})
@Data @NoArgsConstructor
public class Item {

    public static final String ITEM_QUERY = "Item.getItem";

    public static final String ALL_ITEM_QUERY = "Item.getAllItems";

    public Item(ItemType itemType) {
        this.itemType=itemType;
    }

    @Id
    @Column(name = "ID")
    private int itemId;

    @Min(value = 0, message = "The value must be positive")
    private Integer price;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="item_status_id")
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn(name="item_type_id")
    private ItemType itemType;
}







