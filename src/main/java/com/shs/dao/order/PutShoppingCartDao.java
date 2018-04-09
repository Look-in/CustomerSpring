/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Recording user order from the ShoppingCart
 */
package com.shs.dao.order;

import com.shs.entity.orders.Order;

public interface PutShoppingCartDao {

    void putOrder(Order order);
}
