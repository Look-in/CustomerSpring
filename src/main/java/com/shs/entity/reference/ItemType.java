/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Reference Item Type
 */
package com.shs.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("ITEM_TYPE"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemType {

    @Id
    @Column(name = "ID")
    private int itemTypeId;

    @Column(name = "ITEM_TYPE")
    private String type;
}

