package com.shs.entity.orders;

import com.shs.entity.items.Item;
import com.shs.entity.reference.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * User Order consists of List Items and order attributes.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Entity
@Table(name = ("ORDERS"))
@NamedQueries({
        @NamedQuery(name = Order.ALL_ORDER_QUERY,
                query = "select e from Order e WHERE e.username = :username"),
        @NamedQuery(name = Order.ORDER_QUERY,
                query = "select e from Order e WHERE e.OrderId = :id")
})
@Data
@NoArgsConstructor
public class Order {

    public static final String ORDER_QUERY = "Order.getOrder";

    public static final String ALL_ORDER_QUERY = "Order.getAllOrders";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer OrderId;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_ID"))
    private List<Item> items = new LinkedList<>();

    private String username;

    public Order(String username, Item item, OrderStatus orderStatus) {
        items.add(item);
        this.username = username;
        this.orderStatus = orderStatus;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
