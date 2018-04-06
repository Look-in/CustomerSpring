package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

public interface ChangeCart {

    void putOrder(String user, Order order);

    void updateShoppingCart(String user, int itemId);

}
