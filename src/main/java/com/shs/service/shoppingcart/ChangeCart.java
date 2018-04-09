/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Interface for managing user orders
 */
package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

public interface ChangeCart {

    void putOrder(String user, Order order);

    void addShoppingCartNewItem(String user, int itemId);

}
