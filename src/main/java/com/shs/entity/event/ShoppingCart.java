package com.shs.entity.event;

import com.shs.entity.orders.Order;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ShoppingCart {

    Map<String,Order> cart = new ConcurrentHashMap<>();
}
