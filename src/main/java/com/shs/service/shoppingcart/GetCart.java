/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for reading user orders
 */
package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

import java.util.List;

public interface GetCart {

    Order readOrder(int orderId);

    List<Order> readUserOrders(String username);

}
