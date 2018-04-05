package com.shs.service;

import com.shs.dao.order.PutShoppingCart;
import com.shs.entity.items.Item;
import com.shs.entity.orders.Order;
import com.shs.entity.event.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ChangeCartImpl implements ChangeCart {

    @Autowired
    private PutShoppingCart shoppingCart;

    @Autowired
    private SupplyService supplyService;

    @Override
    public void putOrder(String user, Order order) {
        shoppingCart.putOrder(order);
        ShoppingCart.cart.remove(user);
    }

    @Override
    public void updateShoppingCart(String user, int itemId) {
        if (ShoppingCart.cart.get(user) == null) {
            ShoppingCart.cart.put(user, new Order(user, supplyService.getItemAttributes(itemId, Item.class)));
        } else {
            ShoppingCart.cart.get(user).addItem(supplyService.getItemAttributes(itemId, Item.class));
        }
    }
}
