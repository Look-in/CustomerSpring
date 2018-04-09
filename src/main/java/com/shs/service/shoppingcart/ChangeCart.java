package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

/**
 * Interface for managing user orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
public interface ChangeCart {

    void putOrder(String user, Order order);

    void addShoppingCartNewItem(String user, int itemId);

}
