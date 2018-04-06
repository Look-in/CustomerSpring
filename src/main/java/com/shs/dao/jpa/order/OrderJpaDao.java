package com.shs.dao.jpa.order;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.order.PutShoppingCart;
import com.shs.dao.order.ReadShoppingCart;
import com.shs.entity.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OrderDao")
public class OrderJpaDao extends BaseJpaDao implements PutShoppingCart, ReadShoppingCart {

    @Override
    public void putOrder(Order order) {
        getEntityManager().merge(order);
        getEntityManager().flush();
    }

    @Override
    public Order readOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> readUserOrders(String username) {
        return getEntityManager().createNamedQuery(Order.ALL_ORDER_QUERY).getResultList();
    }
}
