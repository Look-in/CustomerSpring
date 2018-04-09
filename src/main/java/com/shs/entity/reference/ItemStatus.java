package com.shs.entity.reference;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reference Item Status.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ITEM_STATUS"))
@Data
@NoArgsConstructor
public class ItemStatus {

    @Id
    @Column(name = "ID")
    private int itemStatusId;

    private String status;
}
