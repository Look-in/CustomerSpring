package com.shs.dao.jpa.order;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.order.PutShoppingCart;
import com.shs.entity.orders.Order;
import org.springframework.stereotype.Repository;

@Repository("OrderDao")
public class OrderJpaDao extends BaseJpaDao implements PutShoppingCart {

    @Override
    public void putOrder(Order order) {
        getEntityManager().merge(order);
        getEntityManager().flush();
    }
}
