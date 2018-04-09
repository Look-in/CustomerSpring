/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Map as storage for user shopping cart. Key - username, Value - Order
 */
package com.shs.service.shoppingcart;

import com.shs.entity.orders.Order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ShoppingCart {

    Map<String,Order> shoppingCart = new ConcurrentHashMap<>();
}
