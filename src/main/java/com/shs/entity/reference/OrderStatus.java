package com.shs.entity.reference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("ORDER_STATUS"))
public class OrderStatus {

    @Id
    @Column(name = "ID")
    @Getter @Setter
    private int orderStatusId;

    @Column(name = "STATUS")
    @Getter @Setter
    private String status;

    public OrderStatus(int orderStatusId, String status) {
        this.orderStatusId = orderStatusId;
        this.status = status;
    }

    public OrderStatus() {
    }

    public OrderStatus(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public String toString(){
        return orderStatusId+ " "+status;
    }
}
