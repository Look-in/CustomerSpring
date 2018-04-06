package com.shs.dao.order;

import com.shs.entity.orders.Order;

import java.util.List;

public interface ReadShoppingCart {

    Order readOrder(int orderId);

    List<Order> readUserOrders(String username);
}
