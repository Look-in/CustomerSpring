package com.shs.entity.orders;

import com.shs.entity.items.Item;
import com.shs.entity.reference.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
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


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_ID"),
            inverseJoinColumns = @JoinColumn(name = "item_ID"))
    private List<Item> items = new LinkedList<>();

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
