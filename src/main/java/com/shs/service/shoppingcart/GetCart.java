package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

import java.util.List;

/**
 * Interface for reading user orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface GetCart {

    Order readOrder(int orderId);

    List<Order> readUserOrders(String username);

}
