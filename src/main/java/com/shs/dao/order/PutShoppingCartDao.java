package com.shs.dao.order;

import com.shs.entity.orders.Order;

/**
 * Recording user order from the ShoppingCart.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface PutShoppingCartDao {

    void putOrder(Order order);
}
