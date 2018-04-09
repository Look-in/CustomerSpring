/**
 * @author Serg Shankunas <shserg2012@gmail.com>
 * Implements methods for reading user orders
 */
package com.shs.service.shoppingcart;

import com.shs.dao.order.ReadShoppingCartDao;
import com.shs.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getCartImpl implements GetCart {

    @Autowired
    private ReadShoppingCartDao readShoppingCartDao;

    @Override
    public Order readOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> readUserOrders(String username) {
        return readShoppingCartDao.readUserOrders(username);
    }
}
