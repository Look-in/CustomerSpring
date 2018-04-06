package com.shs.entity.reference;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ORDER_STATUS"))
@Data
@NoArgsConstructor
public class OrderStatus {

    @Id
    @Column(name = "ID")
    private int orderStatusId;

    private String status;

    public OrderStatus(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
}
