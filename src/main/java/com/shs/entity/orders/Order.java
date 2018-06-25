package com.shs.entity.orders;

import com.shs.entity.items.Item;
import com.shs.entity.reference.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
                query = "select e from Order e WHERE e.id = :id")
})
@Data
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static final String ORDER_QUERY = "Order.getOrder";

    public static final String ALL_ORDER_QUERY = "Order.getAllOrders";

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new LinkedList<>();

    private String username;
}
