package com.shs.entity.reference;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Reference Order Status.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ORDER_STATUS"))
@Data
public class OrderStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;

}
