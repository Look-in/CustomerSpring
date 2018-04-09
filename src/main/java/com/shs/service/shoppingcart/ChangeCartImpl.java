package com.shs.service.shoppingcart;

import com.shs.dao.order.PutShoppingCartDao;
import com.shs.dao.reference.OrderStatusDao;
import com.shs.dao.supply.ReadItemDao;
import com.shs.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Implements methods for managing user orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Service
@Transactional
public class ChangeCartImpl implements ChangeCart {

    @Autowired
    private PutShoppingCartDao shoppingCart;

    @Autowired
    private OrderStatusDao orderStatus;


    @Autowired
    @Qualifier("ItemDao")
    private ReadItemDao readItemDao;

    @Override
    public void putOrder(String user, Order order) {
        shoppingCart.putOrder(order);
        ShoppingCart.shoppingCart.remove(user);
    }

    /**
     * If user shopping cart is null, then creating a new Order, and place them into the map,
     * else add new item to existing order.
     */
    @Override
    public void addShoppingCartNewItem(String user, int itemId) {
        if (ShoppingCart.shoppingCart.get(user) == null) {
            ShoppingCart.shoppingCart.put(user, new Order(user, readItemDao.readItem(itemId),
                    orderStatus.readOrderStatus(1)));
        } else {
            ShoppingCart.shoppingCart.get(user).addItem(readItemDao.readItem(itemId));
        }
    }
}
