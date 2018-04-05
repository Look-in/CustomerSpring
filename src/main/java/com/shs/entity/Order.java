package com.shs.entity;

import com.shs.entity.reference.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = ("ORDERS"))
@Data
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "ID")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDER_ITEM",
            joinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<Item> items = new ArrayList<>();

    @Column(name = "username")
    private String user;

    public Order(String user, Item item) {
        orderStatus=new OrderStatus(1);
        items.add(item);
        this.user = user;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
