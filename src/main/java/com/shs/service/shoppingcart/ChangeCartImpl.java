package com.shs.service.shoppingcart;

import com.shs.dao.order.OrderDao;
import com.shs.dao.reference.OrderStatusDao;
import com.shs.dao.entity.ItemDao;
import com.shs.entity.items.Item;
import com.shs.entity.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implements methods for managing user orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Service
@Transactional
public class ChangeCartImpl implements ChangeCart {

    private final ItemDao itemDao;

    private final OrderDao orderDao;

    private final OrderStatusDao orderStatusDao;

    @Autowired
    public ChangeCartImpl(OrderDao orderDao, @Qualifier("ItemDao") ItemDao itemDao, OrderStatusDao orderStatusDao) {
        this.orderDao = orderDao;
        this.itemDao = itemDao;
        this.orderStatusDao = orderStatusDao;
    }

    @Override
    public void putOrder(String user, Order order) {
        Item item = (Item) itemDao.read(4);
        Order oldOrder = orderDao.readOrder(4, item);
        //orderDao.create(order);
        ShoppingCart.shoppingCart.remove(user);
    }

    /**
     * If user shopping cart is null, then creating a new Order, and place them into the map,
     * else add new item to existing order.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void addShoppingCartNewItem(String user, int itemId) {
        Item item = (Item) itemDao.read(itemId);
        if (ShoppingCart.shoppingCart.get(user) == null) {
            Order order = new Order();
            order.setUsername(user);
            order.setOrderStatus(orderStatusDao.read(1));
            order.setItems(new ArrayList<>(Collections.singletonList(item)));
            ShoppingCart.shoppingCart.put(user, order);
        } else {
            ShoppingCart.shoppingCart.get(user).getItems().add(item);
        }
    }
}
