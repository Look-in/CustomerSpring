package com.shs.dao.order;

import com.shs.dao.supply.CrudDao;
import com.shs.entity.items.Item;
import com.shs.entity.orders.Order;

import java.util.List;

/**
 * Reading user orders from the dataSource.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface OrderDao extends CrudDao<Integer, Order> {

    /**
     * Reading order attributes by Id (in developing).
     */
    Order readOrder(int orderId, Item item);

    /**
     * Reading list of customer orders by Username.
     */
    List<Order> readUserOrders(String username);
}
