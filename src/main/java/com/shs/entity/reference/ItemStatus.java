package com.shs.entity.reference;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Reference Item Status.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ITEM_STATUS"))
@Data
@NoArgsConstructor
public class ItemStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;
}
