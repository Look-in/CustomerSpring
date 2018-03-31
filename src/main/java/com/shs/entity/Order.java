package com.shs.entity;

import com.shs.entity.event.Item;

import java.util.List;
import java.util.Date;

public class Order {

    private int orderId;

    private int status;

    private List<Item> items;

    private Date datetimecreate;

    // поля и методы описания подробностей заказа
    public Order(int orderId, byte status, List<Item> items) {
        this.orderId = orderId;
        this.status = status;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getStatus() {
        return status;
    }

    public Date getDatetimecreate() {
        return datetimecreate;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDatetimecreate(Date datetimecreate) {
        this.datetimecreate = datetimecreate;
    }

    @Override
    public String toString() {
        return "Order [orderId =" + orderId + ", status=" + status + "]";
    }
}
