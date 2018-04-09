package com.shs.dao.jpa.order;

import com.shs.dao.jpa.BaseJpaDao;
import com.shs.dao.order.PutShoppingCartDao;
import com.shs.dao.order.ReadShoppingCartDao;
import com.shs.entity.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO that operates with customer orders.
 *
 * @author Serg Shankunas <shserg2012@gmail.com>
 */
@Repository("OrderDao")
public class OrderJpaDao extends BaseJpaDao implements PutShoppingCartDao, ReadShoppingCartDao {

    /**
     * Used to put order to the dataSource
     */
    @Override
    public void putOrder(Order order) {
        getEntityManager().merge(order);
        getEntityManager().flush();
    }

    /**
     * Reading order attributes by Id (in developing).
     */
    @Override
    public Order readOrder(int orderId) {
        return null;
    }

    /**
     * Reading list of customer orders by Username
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> readUserOrders(String username) {
        return getEntityManager().createNamedQuery(Order.ALL_ORDER_QUERY).setParameter("username", username)
                .getResultList();
    }
}
