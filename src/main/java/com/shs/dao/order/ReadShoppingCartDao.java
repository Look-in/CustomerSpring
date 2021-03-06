package com.shs.dao.order;

import com.shs.entity.orders.Order;

import java.util.List;

/**
 * Reading user orders from the dataSource.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface ReadShoppingCartDao {

    /**
     * Reading order attributes by Id (in developing).
     */
    Order readOrder(int orderId);

    /**
     * Reading list of customer orders by Username.
     */
    List<Order> readUserOrders(String username);
}
