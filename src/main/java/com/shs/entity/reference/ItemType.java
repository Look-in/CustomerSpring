package com.shs.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Reference Item Type.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ITEM_TYPE"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ITEM_TYPE")
    private String type;
}

