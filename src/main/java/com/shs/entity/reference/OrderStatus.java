package com.shs.entity.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reference Order Status.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ORDER_STATUS"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {

    @Id
    @Column(name = "ID")
    private int orderStatusId;

    private String status;

}
