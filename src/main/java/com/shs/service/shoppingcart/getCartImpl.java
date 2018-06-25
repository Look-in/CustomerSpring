package com.shs.service.shoppingcart;

import com.shs.dao.order.OrderDao;
import com.shs.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements methods for reading user orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Service
public class getCartImpl implements GetCart {

    private final OrderDao readShoppingCartDao;

    @Autowired
    public getCartImpl(OrderDao readShoppingCartDao) {
        this.readShoppingCartDao = readShoppingCartDao;
    }

    @Override
    public Order readOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> readUserOrders(String username) {
        return readShoppingCartDao.readUserOrders(username);
    }
}
