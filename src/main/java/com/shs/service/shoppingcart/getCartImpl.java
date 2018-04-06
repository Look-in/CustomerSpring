package com.shs.service.shoppingcart;

import com.shs.dao.order.ReadShoppingCart;
import com.shs.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getCartImpl implements GetCart {

    @Autowired
    private ReadShoppingCart readShoppingCart;


    @Override
    public Order readOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> readUserOrders(String username) {
        return readShoppingCart.readUserOrders(username);
    }
}
